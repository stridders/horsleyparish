package model;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@NamedQueries({
        @NamedQuery(name="UserRole.findUserRoles", query="select ur from UserRole ur where ur.user.user_id = :userId")
})
public class UserRole {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "user_role_seq")
    private Long user_role_id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role",insertable = false, updatable = false)
    private Role role;

    public Long getUser_role_id() {
        return user_role_id;
    }

    public void setUser_role_id(Long user_role_id) {
        this.user_role_id = user_role_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
