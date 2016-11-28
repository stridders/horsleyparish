import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jayway.jsonpath.Configuration;
import controllers.User;
import model.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.Application;
import play.Logger;
import play.api.data.ObjectMapping;
import play.api.inject.guice.GuiceApplicationBuilder;
import play.db.jpa.JPA;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;
import security.UserAuthenticator;
import security.model.UserProfile;
import services.DocumentService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.test.Helpers.GET;
import static play.test.Helpers.route;

/**
 * Created by js on 27/11/2016.
 */
public class DocumentIntegrationTest {

    @Inject
    Application application;

    @Inject
    Configuration.Defaults jsonPathConfig;

    @Inject
    DocumentService documentService;

    @Inject
    play.Configuration configuration;

    @Before
    public void setup() {

        Injector injector = Guice.createInjector(new GuiceApplicationBuilder().applicationModule());
        injector.injectMembers(this);
        Configuration.setDefaults(jsonPathConfig);
        Helpers.start(application);
        DocumentService mockDocumentService = mock(DataStoreService.class);
    }

    @After
    public void teardown() {
        Helpers.stop(application);
    }

    @Test
    public void testCreateDocument() {

            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("resources/newDocument").getFile());
            UserProfile userProfile = new UserProfile();
            userProfile.setEmail("test@test.com");

            Http.Context context = mock(Http.Context.class);
            context.current.set(context);
            context.args = new HashMap<>();
            context.args.put(UserAuthenticator.USER_PROFILE_KEY, userProfile);

            .get("http://www.google.com").then().statusCode(200);

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode json = objectMapper.readTree(file);

                    Document document = documentService.create(json);

            } catch (IOException ioe) {
                Logger.debug("Unable to parse 'new_document' file");
            }

    }


}
