package security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;

import model.UserCredentialsJson;
import org.apache.commons.lang3.ArrayUtils;
import play.Logger;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Http.Context;
import play.mvc.Security;
import security.model.UserProfile;
import services.UserService;
import services.transformers.UserTransformer;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by js on 10/11/2016.
 */
public class UserAuthenticator extends Security.Authenticator {

    public static final String AUTH_HEADER = "Authorization";
    public static final String USER_PROFILE_KEY = "USER_PROFILE";
    public static final String USERNAME_KEY = "USER_NAME";
    private static final String INVALID_SESSION_PROFILE = "User profile found for [%s] but request received from [%s]. Authenticating user.";
    private static final String FORMAT_ERROR = "Error parsing HTTP Session profile";

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Inject
    UserService userService;

    @Inject
    UserTransformer userTransformer;

    /**
     * Gets username (equates to numeric userid) from the HTTP session and verifies it against the
     * UserProfile already saved in the session.
     * If no username found or the UserProfile doesn't match, then null is returned.
     * The UI sets username in the HTTP session cookie once a user has logged in.
     * @param ctx
     * @return
     */
    @Override
    public String getUsername(Context ctx) {

        // Get username from session context (passed by UI if user is logged in)
        UserCredentialsJson userCredentials = getUserCredentialsFromHeader(ctx);

        if (userCredentials == null) {
            logger.info("UNAUTHENTICATED USER");
        } else {
            UserProfile userProfile = null;
            String jsonProfile = ctx.session().get(USER_PROFILE_KEY);
            if (jsonProfile == null) {
                userProfile = userService.authenticateUser(userCredentials);
                ctx.session().put(USER_PROFILE_KEY, userProfile.toJsonString());
            } else {
                userProfile = Json.fromJson(Json.parse(jsonProfile), UserProfile.class);
                if (!userCredentials.getEmail().equalsIgnoreCase(userProfile.getEmail())) {
                    userProfile = null;
                    ctx.session().remove(USER_PROFILE_KEY);
                    logger.info(String.format(INVALID_SESSION_PROFILE, userCredentials.getEmail(), userProfile.getEmail()));
                }
            }
        }
        return userCredentials.getEmail();
    }

    public UserCredentialsJson getUserCredentialsFromHeader (Http.Context ctx) {
        logger.debug("Entered getUserCredentialsFromHeader");
        UserCredentialsJson userCredentialsJson = new UserCredentialsJson();
        String authorisation = String.join("",ctx.request().headers().get(AUTH_HEADER));

        if (authorisation != null && authorisation.startsWith("Basic")) {
            String base64Credentials = authorisation.substring("Basic".length()).trim();
            String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
            final String[] values = credentials.split(":", 2);
            userCredentialsJson.setEmail(values[0]);
            userCredentialsJson.setPassword(values[1]);
        }
        return userCredentialsJson;
    }

}
