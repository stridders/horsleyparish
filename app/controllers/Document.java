package controllers;

import com.google.inject.Inject;
import model.DocumentType;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import security.RoleBasedAuthoriser;
import security.UserAuthenticator;
import services.DocumentService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import services.transformers.DocumentTransformer;
import services.transformers.DocumentTypeTransformer;

import javax.servlet.http.HttpServletResponse;

import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by js on 17/08/2016.
 */
public class Document {

    @Inject
    DocumentService documentService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    /**
     * Create a new document
     * @return
     */
    @Transactional
    @Security.Authenticated(UserAuthenticator.class)
    @RoleBasedAuthoriser.RolesAllowed({RoleBasedAuthoriser.Roles.HORSES_MOUTH,
                                       RoleBasedAuthoriser.Roles.HORSLEY_PC,
                                       RoleBasedAuthoriser.Roles.ADMIN
                                      })
    @BodyParser.Of(BodyParser.MultipartFormData.class)
    public Result createDocument() {
        try {
//            model.Document document = documentService.create(request().body().asMultipartFormData());
//            return ok(DocumentTransformer.uploadConfirmation(document)).as("application/hal+json");
            Http.MultipartFormData<File> body = request().body().asMultipartFormData();
            Http.MultipartFormData.FilePart<File> filePart = body.getFile("file");
            if (filePart != null) {
                String fileName = filePart.getFilename();
                String contentType = filePart.getContentType();
                File file = filePart.getFile();
                String filePath = "uploads/" + fileName;
                copy(file.getAbsolutePath(), "uploads/findme.pdf");
                return ok("File uploaded to "+file.getAbsolutePath());
            } else {
                logger.error("error", "Missing file");
                return badRequest();
            }
        } catch(Exception e) {
            String errMsg = e.getMessage();
            logger.error("Error creating new document.",e);
            return badRequest(errMsg);
        }
    }

    public static void copy(String sourcePath, String destinationPath) throws IOException {
        Files.copy(Paths.get(sourcePath), new FileOutputStream(destinationPath));
    }

    /**
     * List documents, optionally filtered by document type and/or group
     * @param docType
     * @param docGroup
     * @return
     */
    @Transactional
    public Result listDocuments(String docType, String docGroup) {
        try {
            logger.debug("Getting list of documents...");
            List<model.Document> documents = documentService.getDocuments(docType,docGroup);
            return ok(DocumentTransformer.transformDocumentList(documents,docType,docGroup)).as("application/hal+json");
        } catch(Exception e) {
            String errMsg = e.getMessage();
            logger.error("Error listing documents.",e);
            return badRequest(errMsg);
        }
    }

    @Transactional
    public Result getDocument(Long id) {
        model.Document document = documentService.getDocumentById(id);
        return ok(document.getDocument()).as("applications/pdf");
    }

    /**
     * List document types, optionally filtered by document type
     * @param doctype
     * @return
     */
    @Transactional
    public Result listDocumentTypes(String doctype) {
        try {
            logger.debug("Getting list of document types...");
            List<DocumentType> documentTypes = documentService.getDocumentTypes(doctype);
            return ok(DocumentTypeTransformer.transformDocumentTypeListToHalJson(documentTypes,doctype)).as("application/hal+json");
        } catch(Exception e) {
            String errMsg = e.getMessage();
            logger.error("Error listing document types.",e);
            return badRequest(errMsg);
        }
    }


}
