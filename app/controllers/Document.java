package controllers;

import com.google.inject.Inject;
import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import exceptionHandlers.ApplicationException;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.BodyParser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import security.RoleBasedAuthoriser;
import security.UserAuthenticator;
import services.DocumentService;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
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
    public Result create() {
        try {
            model.Document document = documentService.create(request().body().asMultipartFormData());
            return ok();
        } catch(Exception e) {
            String errMsg = e.getMessage();
            return badRequest(errMsg);
        }
    }


}
