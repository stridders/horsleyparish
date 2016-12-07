package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.DocumentType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by js on 07/12/2016.
 */
public class DocumentTypesDto {

    @JsonProperty("_Links")
    private SelfLinkDto _links = new SelfLinkDto();

    @JsonProperty("documentTypes")
    private List<DocumentTypeDto> documentTypes = new ArrayList<>();

    public SelfLinkDto get_links() {
        return _links;
    }

    public void set_links(SelfLinkDto _links) {
        this._links = _links;
    }

    public List<DocumentTypeDto> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<DocumentTypeDto> documentTypes) {
        this.documentTypes = documentTypes;
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
