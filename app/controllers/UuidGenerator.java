package controllers;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import play.Logger;
import play.mvc.Result;

import java.util.UUID;

import static play.mvc.Results.ok;

/**
 * Created by js on 08/11/2016.
 */
public class UuidGenerator {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    public Result randomUUID() {
        String uuid = UUID.randomUUID().toString();
        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation rep = rf.newRepresentation();

        rep.withLink("self", Root.stripApiContext(routes.UuidGenerator.randomUUID().url()));
        rep.withProperty("uuid",uuid);

        return ok(rep.toString(RepresentationFactory.HAL_JSON)).as("application/hal+json");
    }

}
