package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.RoleEnum;

import javax.persistence.*;

@Table
@Entity(name = "roles")
public class RoleEntity extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public RoleEnum getRole() {
        return role;
    }

    public RoleEntity setRole(RoleEnum name) {
        this.role = name;
        return this;
    }
}
