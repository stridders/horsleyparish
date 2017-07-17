package controllers;

import com.google.api.services.drive.model.File;
import com.google.inject.Inject;
import play.Logger;
import play.mvc.Result;
import services.GoogleDriveService;

import java.util.List;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

/**
 * Created by js on 17/08/2016.
 */
public class Google {

    @Inject
    GoogleDriveService googleDriveService;

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    /**
     * List Google Drive documents
     * @param folder
     * @return
     */
    public Result listDocuments(String folder) {
        try {
            logger.debug("Getting list of Google documents");
            List<File> files = googleDriveService.getFileList(folder);
            return ok(files.toString()).as("application/hal+json");
        } catch(Exception e) {
            return badRequest("ERROR: "+e.getMessage());
        }
    }


    /**
     * Downloads a given file by fileId
     * @param id
     * @return
     */
    public Result getFile(String id) {
        try {
            logger.debug("Getting File: {}",id);
            String file = googleDriveService.getFile(id);
            return ok(file);
        } catch(Exception e) {
            return badRequest("ERROR: "+e.toString());
        }
    }

}
