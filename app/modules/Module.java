package modules;

import com.google.inject.AbstractModule;
import com.typesafe.config.Config;
import controllers.UuidGenerator;
import play.Environment;
import play.libs.akka.AkkaGuiceSupport;
import services.DocumentGroupService;
import services.DocumentGroupServiceImpl;
import services.DocumentService;
import services.DocumentServiceImpl;
import services.DocumentTypeService;
import services.DocumentTypeServiceImpl;
import services.GoogleDriveService;
import services.GoogleDriveServiceImpl;
import services.UserService;
import services.UserServiceImpl;


/**
 * Created by js on 23/06/2016.
 */
public class Module extends AbstractModule implements AkkaGuiceSupport {

    Environment environment;
    Config config;

    public Module(Environment environment, Config config) {
        this.environment = environment;
        this.config = config;
    }

    @Override
    protected void configure() {
        // Bind service classes to their implementations
        bind(UserService.class).to(UserServiceImpl.class);
        bind(DocumentService.class).to(DocumentServiceImpl.class);
        bind(DocumentTypeService.class).to(DocumentTypeServiceImpl.class);
        bind(DocumentGroupService.class).to(DocumentGroupServiceImpl.class);
        bind(GoogleDriveService.class).to(GoogleDriveServiceImpl.class);
        requestStaticInjection(UuidGenerator.class);
        requestStaticInjection(UserServiceImpl.class);
    }

}
