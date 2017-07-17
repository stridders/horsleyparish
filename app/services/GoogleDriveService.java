package services;

import com.google.api.services.drive.model.File;
import exceptionHandlers.ApplicationException;

import java.nio.file.Files;
import java.util.List;

/**
 * Created by jstride on 27/06/2017.
 */
public interface GoogleDriveService {

    List<File> getFileList(String folder) throws ApplicationException;

    String getFile(String fileId) throws ApplicationException;
}
