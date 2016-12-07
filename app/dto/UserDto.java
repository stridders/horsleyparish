package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by js on 07/12/2016.
 */
public class UserDto {

    @JsonProperty("_Links")
    private SelfLinkDto _links = new SelfLinkDto();

    @JsonProperty("email")
    private String email;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("userId")
    private Long userId;


    public SelfLinkDto get_links() {
        return _links;
    }

    public void set_links(SelfLinkDto _links) {
        this._links = _links;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
