package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by js on 07/12/2016.
 */
public class UsersDto {

    @JsonProperty("_Links")
    private SelfLinkDto _links = new SelfLinkDto();

    @JsonProperty("users")
    private List<UserDto> users = new ArrayList<>();

    public SelfLinkDto get_links() {
        return _links;
    }

    public void set_links(SelfLinkDto _links) {
        this._links = _links;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
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
