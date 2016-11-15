package security;

import com.google.inject.Inject;

import play.Logger;
import play.libs.Json;
import play.mvc.Http.Context;
import play.mvc.Security;
import security.model.UserProfile;

/**
 * Created by js on 10/11/2016.
 */
public class UserAuthenticator extends Security.Authenticator {

    public static final String USER_PROFILE_KEY = "USER_PROFILE";
    private static final String INVALID_SESSION_PROFILE = "Invalid user profile in HTTP Session. User[%s]  profile[%s]";
    private static final String FORMAT_ERROR = "Error parsing HTTP Session profile";

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Inject
    private static play.mvc.Security.Authenticator delegatedAuthenticator;

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
        String userid = delegatedAuthenticator.getUsername(ctx);

        if (userid == null) {
            logger.info("UNAUTHORISED USER");
        } else {
            UserProfile userProfile = null;
            String jsonProfile = ctx.session().get(USER_PROFILE_KEY);
            if (jsonProfile == null) {
                logger.info("UNAUTHENTICATED USER");
            } else {
                try {
                    userProfile = Json.fromJson(Json.parse(jsonProfile), UserProfile.class);
                    if (!userid.equalsIgnoreCase(userProfile.getUserid())) {
                        userProfile = null;
                        ctx.session().remove(USER_PROFILE_KEY);
                        logger.warn(String.format(INVALID_SESSION_PROFILE, userid, userProfile.getEmail()));
                    }
                } catch (Exception e) {
                    logger.error(String.format(FORMAT_ERROR,jsonProfile));
                }
            }
        }
        return userid;
    }

}
