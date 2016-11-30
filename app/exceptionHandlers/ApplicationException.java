package exceptionHandlers;

/**
 * Created by jstride on 29/11/2016.
 */
public class ApplicationException extends Exception {

    public static final String DOCUMENT__MISSING_FILE_EXTENSION          = "INVALID FILE NAME. File name should include an extension prefex. E.G. '.pdf' or '.doc'";
    public static final String DOCUMENT__MISSING_MULTIPART_DATA          = "INVALID UPLOAD REQUEST. Expected file and/or supporting meta data is missing";

    public ApplicationException(String message) {
        super(message);
    }

}
