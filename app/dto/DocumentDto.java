package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by js on 07/12/2016.
 */
public class DocumentDto {

    @JsonProperty("_Links")
    private SelfLinkDto _links = new SelfLinkDto();

    @JsonProperty("documentId")
    private Long documentId;

    @JsonProperty("documentType")
    private String documentType;

    @JsonProperty("documentPath")
    private String documentPath;

    @JsonProperty("format")
    private String format;

    @JsonProperty("fileName")
    private String fileName;

    @JsonProperty("uploadDate")
    private String uploadDate;

    @JsonProperty("fileSize")
    private Integer fileSize;

    @JsonProperty("user")
    private String user;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public SelfLinkDto get_links() {
        return _links;
    }

    public void set_links(SelfLinkDto _links) {
        this._links = _links;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch(IOException ioe) {
            return null;
        }
    }

}
