package controllers;

import com.google.inject.Inject;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Result;
import play.mvc.Security;
import security.RoleBasedAuthoriser;
import security.UserAuthenticator;
import services.DocumentService;
import services.transformers.DocumentTransformer;

import java.io.IOException;

import static controllers.Root.stripApiContext;
import static play.mvc.Http.Context.Implicit.request;
import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by js on 17/08/2016.
 */
public class Document {

    @Inject
    DocumentService documentService;

    @Transactional
    @Security.Authenticated(UserAuthenticator.class)
    @RoleBasedAuthoriser.RolesAllowed({RoleBasedAuthoriser.Roles.HORSES_MOUTH,
                                       RoleBasedAuthoriser.Roles.HORSLEY_PC,
                                       RoleBasedAuthoriser.Roles.ADMIN,
                                       RoleBasedAuthoriser.Roles.TEST_ROLE_1})
    @BodyParser.Of(BodyParser.Json.class)
    public Result create() {
        try {
            model.Document document = documentService.create(request().body().asJson());
            return ok(document.toMetaDataString());
        } catch(IOException ioe) {
            String errMsg = ioe.getMessage();
            return badRequest(errMsg);
        }
    }



}
