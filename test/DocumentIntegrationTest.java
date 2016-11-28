import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.jayway.jsonpath.Configuration;
import controllers.User;
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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;
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
    public void testCreateDocument() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("new_document").getFile());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode json = objectMapper.readTree(file);
            JPA.withTransaction(() -> {
                Logger.debug("In here: "+json);
            });
        } catch (IOException ioe) {
            Logger.debug("Unable to parse 'new_document' file");
        }

    }


}
