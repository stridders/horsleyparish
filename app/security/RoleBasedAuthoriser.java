package security;

import play.Logger;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.With;
import security.model.UserProfile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

/**
 * Created by js on 15/11/2016.
 */
public class RoleBasedAuthoriser {

    @With(AuthorisedAction.class)
    @Target({ ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RolesAllowed {
        String[] value();
    }

    public interface Roles {
        public static final String ADMIN = "ADMIN";
        public static final String HORSES_MOUTH = "HORSES_MOUTH";
        public static final String HORSLEY_PC = "HORSLEY_PC";
    }

    public static class AuthorisedAction extends Action<RolesAllowed> {

        @Override
        public F.Promise<Result> call(Http.Context ctx) {

            Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

            String username = ctx.request().username();
            UserProfile userProfile = (UserProfile)ctx.args.get(UserAuthenticator.USER_PROFILE_KEY);

            boolean authorised = false;

            if (authorised) {
                return (F.Promise<Result>) delegate.call(ctx);
            } else {
                String msg = (String.format("User %s not authorised for %s path %s. User has roles: %s",
                        username, ctx.request().method(), ctx.request().path(), Arrays.toString(configuration.value())));
                logger.info(msg);
                return F.Promise.promise(() -> forbidden(msg));
            }
        }
    }
}
