package nl.alexdewaal66.novi.vessels.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(nl.alexdewaal66.novi.vessels.model.AuthorityKey.class)
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String role;

    public Authority() {}
    public Authority(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String authority) {
        this.role = authority;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
