package nl.alexdewaal66.novi.vessels.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;
import nl.alexdewaal66.novi.vessels.infrastructure.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity @ToString
public class Role extends BaseEntity<Role> {

    public enum Roles {
        MEMBER(1L, "ROLE_MEMBER"),
        EXPERT(2L, "ROLE_EXPERT"),
        ADMIN(3L, "ROLE_ADMIN"),
        DEMIURG(4L, "ROLE_DEMIURG");

        public final Long id;
        public final String label;

        private Roles(Long id, String label) {
            this.id = id;
            this.label = label;
        }

    }

    @JsonIgnore
    @Override
    public List<String> getTextProperties() {
        return List.of("name");
    }

    @NotBlank(message = "Rolename is mandatory")
    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
