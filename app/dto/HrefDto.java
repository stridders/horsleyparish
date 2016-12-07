package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.DocumentType;

/**
 * Created by js on 07/12/2016.
 */
public class HrefDto {

    @JsonProperty("href")
    private String href;

    public HrefDto() {};

    public HrefDto(String href) {
        this.setHref(href);
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
