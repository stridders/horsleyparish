package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@NamedQueries({

})
public class Role implements Serializable  {

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "role")
    private String role;

    @Column(name = "description")
    private String description;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
