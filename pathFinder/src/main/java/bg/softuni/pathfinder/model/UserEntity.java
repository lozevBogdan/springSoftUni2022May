package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.LevelEnum;
import bg.softuni.pathfinder.model.enums.RoleEnum;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// In this way we choose to have composite uniq for more than one column :
//@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = {"id","userName"}))

@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private int age;

    @Column
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))

    private Set<RoleEntity> roles = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    private String fullName;

    public String getUsername() {
        return username;
    }

    public UserEntity() {
        RoleEnum userRole = RoleEnum.USER;
        RoleEntity usRole = new RoleEntity();
        usRole.setRole(userRole);

        this.roles.add(usRole);
    }

    public int getAge() {
        return age;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
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
