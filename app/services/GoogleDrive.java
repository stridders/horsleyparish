package services;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.Drive.Files;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import play.Environment;
import play.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * A basic class for downloading files with google drive API.
 */
public class GoogleDrive {

    private Logger.ALogger logger = Logger.of(this.getClass().getCanonicalName());

    Drive drive;

    /**
     * Initialize initials attributes
     */
    public GoogleDrive(Environment environment){

        logger.debug("entered GoogleDrive");
        try {
            JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();

            InputStream fileStream = environment.resourceAsStream("HorsleyParish-5ed0ba3ea4b3.pem");

            if (nonNull(fileStream)) {
                GoogleCredential credential = GoogleCredential.fromStream(fileStream)
                        .createScoped(Collections.singleton(DriveScopes.DRIVE));

                drive = new Drive.Builder(httpTransport, JSON_FACTORY, credential)
                        .setApplicationName("HorsleyParishService")
                        .build();
            } else {
                String msg = "PEM file not found";
                logger.error(msg);
            }

        } catch (Exception e) {
            String msg = "Exception while configuring GoogleNetHttpTransport";
            logger.error(msg,e);
        }
    }


    /**
     * Get the content of a file.
     *
     * @param file
     * @return String content of the file.
     */
    public String downloadTextFile(File file) throws IOException{
        GenericUrl url = new GenericUrl(file.getWebViewLink());
        try {
            HttpResponse response = drive.getRequestFactory().buildGetRequest(url).execute();
            return new Scanner(response.getContent()).useDelimiter("\\A").next();
        } catch (java.util.NoSuchElementException e) {
            String msg = String.format("NoSuchElementException");
            logger.error(msg,e);
        } catch(Exception e) {
            String msg = String.format("Error while executing service request");
            logger.error(msg,e);
        }
        return "";
    }

    /**
     * Get the content of a file.
     * @param fileID
     * @return
     * @throws IOException
     */
    public String downloadTextFile(String fileID) throws IOException{
        logger.debug("entered downloadTextFile");
        logger.debug("service:"+isNull(drive));
        File file=drive.files().get(fileID).execute();
        logger.debug("retrieved file");
        return downloadTextFile(file.getName());
    }

    /**
     * Get the file viewer URL.
     * @param fileId
     * @return
     * @throws IOException
     */
    public String getFileView(String fileId) throws IOException{
        File file=drive.files().get(fileId).execute();
        return downloadTextFile(file);
    }

    /**
     * Retrieve a list of File resources.
     *
     * @return List of File resources.
     * @author Google
     * @throws IOException
     */
    public List<File> retrieveAllFiles(String folder) throws IOException {
        logger.debug("Entered retrieveAllFiles");
        List<File> result = new ArrayList<File>();
        Files.List request = null;

        request = drive.files().list();
        FileList files = request.setQ("'"+folder+"' in parents and trashed=false").execute();
        result.addAll(files.getFiles());
        request.setPageToken(files.getNextPageToken());

        logger.debug(String.format("Retrieved %d files from folder",result.size()));

        return result;
    }

}
