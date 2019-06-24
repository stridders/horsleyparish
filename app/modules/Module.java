package modules;

import com.google.inject.AbstractModule;
import controllers.UuidGenerator;
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
public class Module extends AbstractModule  {

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
