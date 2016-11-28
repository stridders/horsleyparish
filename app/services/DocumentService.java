package services;

import com.fasterxml.jackson.databind.JsonNode;
import model.Document;
import model.DocumentType;
import model.User;
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
     * @param json
     * @return
     */
    Document create(JsonNode json) throws IOException;

}
