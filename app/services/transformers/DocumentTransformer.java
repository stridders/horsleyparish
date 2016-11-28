package services.transformers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import controllers.Root;
import model.Document;
import model.DocumentType;
import model.User;
import play.Logger;
import security.model.UserProfile;
import services.DocumentService;
import sun.util.calendar.CalendarDate;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by js on 09/11/2016.
 */
public class DocumentTransformer {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    /**
     * Tranforms a JSON Node into a Document POJO
     */
    public static Document transformJsonToDocument(JsonNode json,
                                                   Map<String, DocumentType> docTypes,
                                                   User user) throws IOException {
        Document document = new Document();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        document.setDocumentId(json.findPath("documentId").asLong());
        document.setDocument(json.findPath("document").binaryValue());
        String docType = json.findPath("documentType").asText();
        if (docType != null) {
            document.setDocumentType(docTypes.get(docType));
        }
        document.setFormat(json.findPath("format").asText());
        document.setName(json.findPath("name").asText());
        document.setUploadDate(cal);
        document.setUser(user);
        return document;
    }


}
