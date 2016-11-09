package services.transformers;

import com.theoryinpractise.halbuilder.api.Representation;
import com.theoryinpractise.halbuilder.api.RepresentationFactory;
import com.theoryinpractise.halbuilder.standard.StandardRepresentationFactory;
import controllers.Root;
import controllers.routes;
import model.User;
import model.UserJson;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by js on 09/11/2016.
 */
public class UserTransformer {

    public static String transformUserListToHalJson (List<User> users,
                                                     String surname,
                                                     String firstname,
                                                     String email) {

        RepresentationFactory rf    = new StandardRepresentationFactory();
        Representation rep = rf.newRepresentation();

        rep.withLink("self", Root.stripApiContext(controllers.routes.User.listUsers(surname,firstname,email).url()));

        List<UserJson> userJsonList = new ArrayList<>();
        users.forEach(user -> {
            userJsonList.add(new UserJson(user));
        });
        rep.withProperty("users", userJsonList);
        StringWriter sw = new StringWriter();
        rep.toString(RepresentationFactory.HAL_JSON,sw);
        return sw.toString();
    }

}
