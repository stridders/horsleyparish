package services;

import com.fasterxml.jackson.databind.JsonNode;
import exceptionHandlers.ApplicationException;
import model.Document;
import model.DocumentType;
import model.User;
import play.mvc.Http;
import security.OAuthCredentials;
import security.model.UserProfile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    /**
     * Returns a list of all documentTypes
     * @return
     */
    List<DocumentType> getDocumentTypes();

    /**
     * returns a DocumentType object for a given document type
     * @param docType
     * @return
     */
    DocumentType getDocumentType(String docType);

    /**
     * Creates a document from a JSON object and saves it to the database.
     * @param form
     * @return
     */
    Document create(Http.MultipartFormData form) throws IOException, ApplicationException;

}
