package security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;
import play.Logger;
import play.libs.F;
import play.libs.Json;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.With;
import security.model.UserProfile;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

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
        public static final String TEST_ROLE_1 = "TEST_ROLE_1";
    }

    public static class AuthorisedAction extends Action<RolesAllowed> {

        Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

        @Override
        public CompletionStage<Result> call(Http.Context ctx) {

            String strProfile = ctx.session().get(UserAuthenticator.USER_PROFILE_KEY);

            UserProfile userProfile = Json.fromJson(Json.parse(strProfile), UserProfile.class);

            boolean authorised = false;

            if (ArrayUtils.isEmpty(configuration.value())) {
                authorised = true;
            } else {
                for (String role : configuration.value()) {
                    if (userProfile != null && userProfile.hasRole(role)) {
                        authorised = true;
                        break;
                    }
                }
            }

            if (authorised) {
                return delegate.call(ctx);
            } else {
                String msg = (String.format("User %s not authorised for %s path %s. Requires %s but user has roles: %s",
                        userProfile.getEmail(), ctx.request().method(), ctx.request().path(), Arrays.toString(configuration.value()), userProfile.getRoles().toString()));
                return CompletableFuture.supplyAsync(() -> forbidden(msg));
            }

        }
    }
}
