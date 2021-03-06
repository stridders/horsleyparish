import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jayway.jsonpath.Configuration;
import controllers.User;
import org.junit.After;
import org.junit.Before;
import play.Application;
import play.mvc.Result;
import org.junit.Test;
import play.api.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.test.Helpers;
import security.UserAuthenticator;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

/**
 * Created by js on 11/11/2016.
 */
public class UserIntegrationTest {

    @Inject
    Application application;

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
    public void testListUsersWithSecurityContextNoAdminRole() {
        Map<String, String[]> headers = new HashMap<>();

        String username = "foo@bar.co.uk";
        String password = "foobar";

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
        assertEquals("User foo@bar.co.uk not authorised for GET path /api/users. Requires [ADMIN] but user has roles: []", response);

    }

//    @Test
//    public void testAuthenticationWithValidCredentials() {
//        Map<String, String[]> headers = new HashMap<>();
//        String username = "bar@test.co.uk";
//        String password = "123abc";
//
//        String usernameAndPassword = username + ":" + password;
//        String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );
//
//        headers.put(UserAuthenticator.AUTH_HEADER, new String[]{authorizationHeaderValue});
//
//        String contextPath = configuration.getString("play.http.context");
//        Http.RequestBuilder request = new Http.RequestBuilder()
//                .method(GET)
//                .headers(headers)
//                .uri(contextPath + "api/authentication");
//
//        Result result = route(request);
//        assertEquals(200,result.status());
//    }

    @Test
    public void testAuthenticationWithInvalidUID() {
        Map<String, String[]> headers = new HashMap<>();
        String username = "unknown@google.co.uk";
        String password = "password";

        String usernameAndPassword = username + ":" + password;
        String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );

        headers.put(UserAuthenticator.AUTH_HEADER, new String[]{authorizationHeaderValue});

        String contextPath = configuration.getString("play.http.context");
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .headers(headers)
                .uri(contextPath + "api/authentication");

        Result result = route(request);
        assertEquals(401,result.status());
    }

    @Test
    public void testAuthenticationWithInvalidPassword() {
        Map<String, String[]> headers = new HashMap<>();
        String username = "foo@bar.co.uk";
        String password = "password";

        String usernameAndPassword = username + ":" + password;
        String authorizationHeaderValue = "Basic " + java.util.Base64.getEncoder().encodeToString( usernameAndPassword.getBytes() );

        headers.put(UserAuthenticator.AUTH_HEADER, new String[]{authorizationHeaderValue});

        String contextPath = configuration.getString("play.http.context");
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .headers(headers)
                .uri(contextPath + "api/authentication");

        Result result = route(request);
        assertEquals(401,result.status());
    }


}
