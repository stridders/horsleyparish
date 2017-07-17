package services;

import com.google.api.services.drive.model.File;
import exceptionHandlers.ApplicationException;
import play.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static play.mvc.Results.redirect;

/**
 * Created by jstride on 27/06/2017.
 */
public class GoogleDriveServiceImpl implements GoogleDriveService {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    @Override
    public List<File> getFileList(String folder) throws ApplicationException {
        logger.debug("Entered getFileList");
        GoogleDrive googleDrive = new GoogleDrive();
        try {
            return googleDrive.retrieveAllFiles(folder);
        } catch(IOException ioe) {
            String msg = "Error while retrieving file information from Google Drive API";
            logger.error(msg,ioe);
            throw new ApplicationException(msg);
        }
    };

    @Override
    public String getFile(String fileId) throws ApplicationException {
        logger.debug("Entered getFile for fileId {}",fileId);
        GoogleDrive googleDrive = new GoogleDrive();
        logger.debug("Initialised googleDrive instance");
        try {
            return googleDrive.downloadTextFile(fileId);
        } catch(IOException ioe) {
            String msg = String.format("IO Exception: Unable to download file %s from the Google Drive API",fileId);
            logger.error(msg,ioe);
            throw new ApplicationException(msg);
        } catch(Exception e) {
            String msg = String.format("Unable to download file %s from the Google Drive API",fileId);
            logger.error(msg,e);
            throw new ApplicationException(msg);
        }
    }
}
