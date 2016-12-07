package controllers;

import com.google.inject.Inject;
import model.DocumentType;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.mvc.Security;
import security.RoleBasedAuthoriser;
import security.UserAuthenticator;
import services.DocumentService;
import java.util.List;
import services.transformers.DocumentTransformer;
import services.transformers.DocumentTypeTransformer;
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

    @Transactional
    @Security.Authenticated(UserAuthenticator.class)
    @RoleBasedAuthoriser.RolesAllowed({RoleBasedAuthoriser.Roles.HORSES_MOUTH,
                                       RoleBasedAuthoriser.Roles.HORSLEY_PC,
                                       RoleBasedAuthoriser.Roles.ADMIN,
                                       RoleBasedAuthoriser.Roles.TEST_ROLE_1})
    @BodyParser.Of(BodyParser.MultipartFormData.class)
    public Result createDocument() {
        try {
            model.Document document = documentService.create(request().body().asMultipartFormData());
            return ok(DocumentTransformer.uploadConfirmation(document)).as("application/hal+json");
        } catch(Exception e) {
            String errMsg = e.getMessage();
            logger.error("Error creating new document.",e);
            return badRequest(errMsg);
        }
    }

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
