import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jayway.jsonpath.Configuration;

import controllers.User;
import org.junit.After;
import org.junit.Before;
import play.Application;
import play.Logger;
import play.mvc.Result;

import org.junit.Test;
import play.api.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.test.Helpers;

import java.io.IOException;

import static junit.framework.TestCase.fail;
import static org.asynchttpclient.util.HttpConstants.Methods.POST;
import static play.test.Helpers.route;

/**
 * Created by js on 11/11/2016.
 */
public class UserIntegrationTest {

    @Inject
    Application application;

    @Inject
    User userCtrly;

    @Inject
    Configuration.Defaults jsonPathConfig;

    @Inject
    play.Configuration configuration;

    @Before
    public void setup() {
        Injector injector = Guice.createInjector(new GuiceApplicationBuilder().applicationModule());
        injector.injectMembers(this);
        Configuration.setDefaults(jsonPathConfig);
        Helpers.start(application);
    }

    @After
    public void teardown() {
        Helpers.stop(application);
    }

    @Test
    public void testAuthenticateUser() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree("{\"email\": \"test@test.co.uk\"}");
            String contextPath = configuration.getString("play.http.context");
            Http.RequestBuilder request = new Http.RequestBuilder()
                    .method(POST)
                    .uri(contextPath + "/api/users/authenticate")
                    .bodyJson(json);

            Result result = route(request);
            String response = Helpers.contentAsString(result);

            Logger.debug("Authentication result: -------> "+response);

        } catch(IOException ioe) {
            fail("ERROR: Json string is invalid." + ioe.getMessage() );
        }
    }
}
