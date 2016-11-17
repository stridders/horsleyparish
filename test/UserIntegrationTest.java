import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Names;
import com.jayway.jsonpath.Configuration;

import controllers.User;
import model.UserJson;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import play.Application;
import play.Logger;
import play.db.jpa.Transactional;
import play.mvc.Result;

import org.junit.Test;
import play.api.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.test.Helpers;
import security.UserAuthenticator;
import security.model.UserProfile;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.asynchttpclient.util.HttpConstants.Methods.POST;
import static play.test.Helpers.GET;
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
    public void testListUsersWithSecurityContext() {
        Map<String, String[]> headers = new HashMap<>();

        String username = "bar@test.co.uk";
        String password = "123abc";

        String usernameAndPassword = username + ":" + password;
        String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );

        headers.put(UserAuthenticator.AUTH_HEADER, new String[]{authorizationHeaderValue});

        String contextPath = configuration.getString("play.http.context");
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .headers(headers)
                .uri(contextPath + "api/users?surname=stride");

        Result result = route(request);
        String response = Helpers.contentAsString(result);

        assertEquals(403,result.status());
        Logger.debug("List users response: -------> "+response+","+result.status());

    }

//    @Test
//    public void testAuthenticateUserNoRoles() {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            JsonNode json = mapper.readTree("{\"email\": \"foo@test.co.uk\", \"password\": \"abc123\"}");
//            String contextPath = configuration.getString("play.http.context");
//            Http.RequestBuilder request = new Http.RequestBuilder()
//                    .method(POST)
//                    .uri(contextPath + "api/users/authenticate")
//                    .bodyJson(json);
//
//            Result result = route(request);
//            String response = Helpers.contentAsString(result);
//
//            Logger.debug("Authentication result: -------> "+response);
//
//        } catch(IOException ioe) {
//            fail("ERROR: Json string is invalid." + ioe.getMessage() );
//        }
//    }
//
//    @Test
//    public void testAuthenticateUserOneRole() {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            JsonNode json = mapper.readTree("{\"email\": \"bar@test.co.uk\", \"password\": \"123abc\"}");
//            String contextPath = configuration.getString("play.http.context");
//            Http.RequestBuilder request = new Http.RequestBuilder()
//                    .method(POST)
//                    .uri(contextPath + "api/users/authenticate")
//                    .bodyJson(json);
//
//            Result result = route(request);
//            String response = Helpers.contentAsString(result);
//
//            Logger.debug("Authentication result: -------> "+response);
//
//        } catch(IOException ioe) {
//            fail("ERROR: Json string is invalid." + ioe.getMessage() );
//        }
//    }
//
//    @Test
//    public void testFailPasswordAuthentication() {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            JsonNode json = mapper.readTree("{\"email\": \"bar@test.co.uk\", \"password\": \"xxxxx\"}");
//            String contextPath = configuration.getString("play.http.context");
//            Http.RequestBuilder request = new Http.RequestBuilder()
//                    .method(POST)
//                    .uri(contextPath + "api/users/authenticate")
//                    .bodyJson(json);
//
//            Result result = route(request);
//            String response = Helpers.contentAsString(result);
//
//            Logger.debug("Authentication result: -------> "+response);
//
//        } catch(IOException ioe) {
//            fail("ERROR: Json string is invalid." + ioe.getMessage() );
//        }
//    }
//
//    @Test
//    public void testNoMatchingUser() {
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            JsonNode json = mapper.readTree("{\"email\": \"unknown@aaa.co.uk\", \"password\": \"whatever\"}");
//            String contextPath = configuration.getString("play.http.context");
//            Http.RequestBuilder request = new Http.RequestBuilder()
//                    .method(POST)
//                    .uri(contextPath + "api/users/authenticate")
//                    .bodyJson(json);
//
//            Result result = route(request);
//            String response = Helpers.contentAsString(result);
//
//            Logger.debug("Authentication result: -------> "+response);
//
//        } catch(IOException ioe) {
//            fail("ERROR: Json string is invalid." + ioe.getMessage() );
//        }
//    }

}
