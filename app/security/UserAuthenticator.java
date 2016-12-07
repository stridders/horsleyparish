package security;

import com.google.inject.Inject;

import play.Logger;
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

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Inject
    UserService userService;

    @Inject
    UserTransformer userTransformer;

    /**
     * Gets username and password from the HTTP session and verifies them against the database.
     * If no username found then null is returned.
     * @param ctx
     * @return
     */
    @Override
    public String getUsername(Context ctx) {

        String userName = null;
        OAuthCredentials credentials = getUserCredentialsFromHeader(ctx);
        ctx.session().remove(USER_PROFILE_KEY);

        if (credentials == null) {
            logger.info("UNAUTHENTICATED USER");
        } else {
            UserProfile userProfile = userService.authenticateUser(credentials);
            if (userProfile != null) {
                ctx.session().put(USER_PROFILE_KEY, userProfile.toString());
                userName = userProfile.getEmail();
                logger.debug("AUTHENTICATED USER");
            } else {
                logger.debug("Still AUTHENTICATED USER");
            }
        }
        return userName;
    }

    /**
     * Returns a OAuthCredentials object, containing a username/password extracted from the
     * HTTP Authentication header (if present)
     * @param ctx
     * @return
     */
    public OAuthCredentials getUserCredentialsFromHeader (Http.Context ctx) {
        logger.debug("Entered getUserCredentialsFromHeader");
        OAuthCredentials credentials = new OAuthCredentials();
        if (!ctx.request().headers().isEmpty() && ctx.request().headers().get(AUTH_HEADER) != null) {
            String authorisation = String.join("",ctx.request().headers().get(AUTH_HEADER));
            if (authorisation != null && authorisation.startsWith("Basic")) {
                String base64Credentials = authorisation.substring("Basic".length()).trim();
                String hdr = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
                final String[] hdrValues = hdr.split(":", 2);
                credentials.setEmail(hdrValues[0]);
                credentials.setPassword(hdrValues[1]);
            }
        }
        return credentials;
    }

}
