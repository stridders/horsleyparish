package services.transformers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import controllers.Root;
import dto.DocumentDto;
import dto.DocumentsDto;
import dto.HrefDto;
import exceptionHandlers.ApplicationException;
import model.Document;
import model.DocumentGroup;
import model.DocumentType;
import model.User;
import play.Logger;
import play.mvc.Http;
import security.model.UserProfile;
import services.DocumentGroupService;
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

import static java.lang.Integer.valueOf;
import static java.util.Objects.nonNull;

/**
 * Created by js on 09/11/2016.
 */
public class DocumentTransformer {

    /**
     * Returns a Document PJO, built from MultipartFormData
     * @param form
     * @param docTypes
     * @param user
     * @return
     * @throws IOException
     * @throws ApplicationException
     */
    public static Document createPOJO(Http.MultipartFormData form,
                                 Map<String, DocumentType> docTypes,
                                 User user)
                                throws IOException, ApplicationException {
        Document document = new Document();
        String documentType;
        Calendar cal = Calendar.getInstance();

        Http.MultipartFormData.FilePart filePart = form.getFile("file");
        String fileName = filePart.getFilename();

        Map<String,String[]> formData = form.asFormUrlEncoded();

        document.setName(getFileName(fileName));
        if (nonNull(formData.get("fileTitle"))) {
            String fileTitle = Arrays.asList(formData.get("fileTitle")).toString().replaceAll("[\\[\\]]", "");
            if (!fileTitle.equals("null")) {
                document.setName(fileTitle);
            }
        }
        document.setDocumentType(docTypes.get("MISC"));
        if (nonNull(formData.get("docType"))) {
            documentType = Arrays.asList(formData.get("docType")).toString().replaceAll("[\\[\\]]","");
            if (!documentType.equals("null")) {
                document.setDocumentType(docTypes.get(documentType));
            }
        }
        document.setSize(null);
        if (nonNull(formData.get("fileSize"))) {
            String size = Arrays.asList(formData.get("fileSize")).toString().replaceAll("[\\[\\]]","");
            if (!size.equals("null")) {
                document.setSize(valueOf(size));
            }
        }
        document.setFormat(getFileExtension(fileName));
        String filePath = "public/uploads/" + document.getName()+"."+document.getFormat();
        document.setDocumentPath(filePath);
        document.setUploadDate(cal);
        document.setUser(user);

        return document;
    }

    /**
     * Returns a JSON representation of a collection of documents
     * @param documents
     * @param docType
     * @param docGroup
     * @return
     */
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
        dto.setFileSize(document.getSize());
        dto.setFileName(document.getName());
        dto.setFormat(document.getFormat());
        dto.setUploadDate(document.getUploadDateAsString());
        dto.setUser(document.getUser().getEmail());
        dto.setDocumentPath(document.getDocumentPath().replace("public","glos"));
        return dto;
    }

    /**
     * Returns a Document upload confirmation representation
     * @param document
     * @return
     */
    public static String uploadConfirmation(Document document) {
        DocumentDto dto = transformDocumentToDto(document);
        HrefDto href = new HrefDto(Root.stripApiContext(controllers.routes.Document.createDocument().url()));
        dto.get_links().setSelf(href);
        StringWriter sw = new StringWriter();
        sw.write(dto.toString());
        return sw.toString();
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

    /**
     * Returns a file name without the file extension (e.g. without '.pdf')
     * @param fileName
     * @return
     * @throws ApplicationException
     */
    public static String getFileName(String fileName) throws ApplicationException {
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            String extension = fileName.substring(0,i-1);
            return extension.toLowerCase();
        } else {
            throw new ApplicationException(ApplicationException.DOCUMENT__MISSING_FILE_EXTENSION);
        }
    }

}
