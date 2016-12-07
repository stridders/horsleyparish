package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by js on 07/12/2016.
 */
public class SelfLinkDto {

    @JsonProperty("self")
    private HrefDto self = new HrefDto();

    public HrefDto getSelf() {
        return self;
    }

    public void setSelf(HrefDto href) {
        this.self = href;
    }

}
