package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.LevelEnum;
import bg.softuni.pathfinder.model.enums.RoleEnum;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table
@Entity
public class UserEntity extends BaseEntity {

    @NotNull
    @Size(min = 2)
    private String username;

    @NotNull
    @Size(min = 2)
    private String password;

    @NotNull
    @Email
    private String email;

    @OneToMany
    private Set<RoleEntity> roles = new HashSet<>();


    private LevelEnum level;

    public String getUsername() {
        return username;
    }

    public UserEntity() {
        RoleEnum userRole = RoleEnum.USER;
        RoleEntity usRole = new RoleEntity();
        usRole.setName(userRole);

        this.roles.add(usRole);
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public UserEntity setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }
}
