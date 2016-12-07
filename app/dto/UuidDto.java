package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by js on 07/12/2016.
 */
public class UuidDto {

    @JsonProperty("_Links")
    private SelfLinkDto _links = new SelfLinkDto();

    @JsonProperty("uuid")
    private String uuid;

    public SelfLinkDto get_links() {
        return _links;
    }

    public void set_links(SelfLinkDto _links) {
        this._links = _links;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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
