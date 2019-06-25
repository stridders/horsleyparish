package controllers;

import com.google.inject.Inject;
import model.DocumentType;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Result;
import services.DocumentService;
import services.DocumentTypeService;
import services.transformers.DocumentTransformer;
import services.transformers.DocumentTypeTransformer;

import java.util.List;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by js on 17/08/2016.
 */
public class Document {

    @Inject
    DocumentService documentService;

    @Inject
    DocumentTypeService documentTypeService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    /**
     * Create a new document
     * @return
     */
//    @Transactional
//    @Security.Authenticated(UserAuthenticator.class)
//    @BodyParser.Of(BodyParser.MultipartFormData.class)
//    public Result createDocument() {
//        try {
//            Http.MultipartFormData<File> body = request().body().asMultipartFormData();
//            model.Document document = documentService.create(body);
//            return ok(DocumentTransformer.uploadConfirmation(document)).as("application/hal+json");
//        } catch(Exception e) {
//            String errMsg = "Error creating new document."+ e.getMessage();
//            logger.error("Error creating new document.",e);
//            return badRequest(errMsg);
//        }
//    }


    /**
     * List documents, optionally filtered by document type and/or group
     * @param docType
     * @param docGroup
     * @return
     */
    @Transactional(readOnly = true)
    public Result listDocuments(String docType, String docGroup) {
        try {
            logger.debug("Getting list of documents...");
            List<model.Document> documents = documentService.getAll(docType,docGroup);
            return ok(DocumentTransformer.transformDocumentList(documents,docType,docGroup)).as("application/hal+json");
        } catch(Exception e) {
            String errMsg = e.getMessage();
            logger.error("Error listing documents.",e);
            return badRequest(errMsg);
        }
    }

    @Transactional(readOnly = true)
    public Result getDocument(Long id) {
        model.Document document = documentService.get(id);
        return ok(document.toString()).as("applications/pdf");
    }

    /**
     * List document types, optionally filtered by document type
     * @param doctype
     * @param role
     * @return
     */
    @Transactional(readOnly = true)
    public Result listDocumentTypes(String doctype, String role) {
        try {
            logger.debug("Getting list of document types...");
            List<DocumentType> documentTypes = documentTypeService.getAll(doctype,role);
            return ok(DocumentTypeTransformer.convertToJson(documentTypes,doctype,role)).as("application/hal+json");
        } catch(Exception e) {
            String errMsg = e.getMessage();
            logger.error("Error listing document types.",e);
            return badRequest(errMsg);
        }
    }


}
