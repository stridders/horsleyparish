package model;

public class UserJson {

    private static final long serialVersionUID = 1L;

    private Long   userId;
    private String surname;
    private String firstname;
    private String email;
    private String password;

    public UserJson(User user) {
        this.userId = user.getUser_id();
        this.surname = user.getSurname();
        this.firstname = user.getFirstname();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

