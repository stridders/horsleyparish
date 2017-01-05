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
import java.util.Map;

public interface DocumentService {

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
    List<Document> getAll(String docType, String docGroup);

    /**
     * Get Document by document ID. Returns document image with metadata
     * @param id
     * @return
     */
    Document get(Long id);

    /**
     * Returns a map of documentType POJOs, keyed on documentType
     * @return
     */
    Map<String, DocumentType> mapDocumentTypes();

}
