package services.transformers;

import com.fasterxml.jackson.databind.JsonNode;
import controllers.Root;
import dto.DocumentDto;
import dto.DocumentsDto;
import dto.HrefDto;
import exceptionHandlers.ApplicationException;
import model.Document;
import model.DocumentType;
import model.User;
import play.Logger;
import play.mvc.Http;
import security.model.UserProfile;
import services.DocumentService;
import sun.util.calendar.CalendarDate;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by js on 09/11/2016.
 */
public class DocumentTransformer {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());


    /**
     * Returns a Document PJO, built from MultipartFormData
     * @param form
     * @param docTypes
     * @param user
     * @return
     * @throws IOException
     * @throws ApplicationException
     */
    public static Document createDocument(Http.MultipartFormData form,
                                             Map<String, DocumentType> docTypes,
                                             User user)
                                            throws IOException, ApplicationException {
        Document document = new Document();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        Http.MultipartFormData.FilePart filePart = form.getFile("file");
        String fileName = filePart.getFilename();
        byte[] file = serialize(filePart.getFile());

        Map<String,String[]> formData = form.asFormUrlEncoded();
        String name = Arrays.asList(formData.get("name")).toString().replaceAll("[\\[\\]]","");
        String documentType = Arrays.asList(formData.get("documentType")).toString().replaceAll("[\\[\\]]","");
        if (documentType != null) {
            document.setDocumentType(docTypes.get(documentType));
        }

        document.setDocument(file);
        document.setFormat(getFileExtension(fileName));
        document.setName(name);
        document.setUploadDate(cal);
        document.setUser(user);
        return document;
    }

    public static String transformDocumentList(List<Document> documents, String docType, String docGroup) {
        DocumentsDto dto = new DocumentsDto();
        HrefDto href = new HrefDto(Root.stripApiContext(controllers.routes.Document.listDocuments(docType,docGroup).url()));
        dto.get_links().setSelf(href);
        documents.forEach(doc -> {
            DocumentDto documentDto = transformDocumentToDto(doc);
            dto.getDocuments().add(documentDto);
        });
        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return sw.toString();
    }

    /**
     * Converts a Document DTO into a String
     * @param document
     * @return
     */
    public static String transformDocumentToString(Document document) {
        DocumentDto dto = transformDocumentToDto(document);
        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return sw.toString();
    }

    /**
     * Converts a Document POJO to a Document DTO
     * @param document
     * @return
     */
    public static DocumentDto transformDocumentToDto(Document document) {
        DocumentDto dto = new DocumentDto();
        HrefDto href = new HrefDto(Root.stripApiContext(controllers.routes.Document.getDocument(document.getDocumentId()).url()));
        dto.get_links().setSelf(href);
        dto.setDocumentId(document.getDocumentId());
        dto.setDocumentType(document.getDocumentType().getDocumentType());
        dto.setFileName(document.getName());
        dto.setFormat(document.getFormat());
        dto.setUploadDate(document.getUploadDateAsString());
        dto.setUser(document.getUser().getEmail());
        return dto;
    }

    /**
     * Returns a Document upload confirmation representation
     * @param document
     * @return
     */
    public static String uploadConfirmation(Document document) {
        DocumentDto dto = new DocumentDto();
        HrefDto href = new HrefDto(Root.stripApiContext(controllers.routes.Document.createDocument().url()));
        dto.get_links().setSelf(href);
        dto.setDocumentType(document.getDocumentType().getDocumentType());
        dto.setFormat(document.getFormat());
        dto.setFileName(document.getName());
        dto.setUploadDate(document.getUploadDateAsString());
        dto.setUser(document.getUser().getEmail());
        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return sw.toString();
    }

    /**
     * Converts a Java Object into a Byte Array
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] serialize(Object obj) throws IOException {
        try(ByteArrayOutputStream b = new ByteArrayOutputStream()){
            try(ObjectOutputStream o = new ObjectOutputStream(b)){
                o.writeObject(obj);
            }
            return b.toByteArray();
        }
    }

    /**
     * Returns the file extension (i.e. file format) from a file name
     * @param fileName
     * @return
     * @throws ApplicationException
     */
    public static String getFileExtension(String fileName) throws ApplicationException {
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            String extension = fileName.substring(i+1);
            return extension.toLowerCase();
        } else {
            throw new ApplicationException(ApplicationException.DOCUMENT__MISSING_FILE_EXTENSION);
        }
    }


}
