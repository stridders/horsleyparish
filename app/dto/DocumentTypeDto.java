package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.DocumentType;

import java.io.IOException;

/**
 * Created by js on 07/12/2016.
 */
public class DocumentTypeDto {

    @JsonProperty("documentType")
    private String documentType;

    @JsonProperty("description")
    private String description;

    public DocumentTypeDto() {};

    public DocumentTypeDto(DocumentType dt) {
        this.setDocumentType(dt.getDocumentType());
        this.setDescription(dt.getDescription());
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
