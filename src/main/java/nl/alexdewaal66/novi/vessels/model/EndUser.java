package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity @ToString
//@Table(name = "users")
public class EndUser {

    @NotBlank(message = "Username is mandatory")
    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "Password is mandatory")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ToString.Exclude
    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false)
    private boolean enabled = true;

    @Column
    private String apikey;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Not a valid email address")
    @Column
    private String email = "";

    @OneToMany(
            targetEntity = nl.alexdewaal66.novi.vessels.model.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<Authority> authorities = new HashSet<>();

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isEnabled() { return enabled;}
    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public String getApikey() { return apikey; }
    public void setApikey(String apikey) { this.apikey = apikey; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}

    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

}