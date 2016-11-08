package model;

import javax.persistence.*;

/**
 * Created by js on 08/11/2016.
 */
@Entity
@Table(name = "USER")
@NamedQueries({
        @NamedQuery(name="User.findBySurname", query="SELECT u FROM USER u WHERE u.surname = :surname")
})
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "user_seq")
    private Long id;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "EMAIL")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

