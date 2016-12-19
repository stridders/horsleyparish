package services;

import com.fasterxml.jackson.databind.JsonNode;
import exceptionHandlers.ApplicationException;
import model.Document;
import model.DocumentType;
import model.User;
import play.mvc.Http;
import security.OAuthCredentials;
import security.model.UserProfile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface DocumentService {

    /**
     * Returns a list of all documentTypes filtered on documentType
     * @return
     */
    List<DocumentType> getDocumentTypes(String filter);

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
     * @param body
     * @return
     */
    Document create(Http.MultipartFormData<File> body) throws IOException, ApplicationException;

    /**
     * List Documents, optionally filtered by document type and/or group
     * @param docType
     * @param docGroup
     * @return
     */
    List<Document> getDocuments(String docType, String docGroup);

    /**
     * Get Document by document ID. Returns document image with metadata
     * @param id
     * @return
     */
    Document getDocumentById(Long id);
}
