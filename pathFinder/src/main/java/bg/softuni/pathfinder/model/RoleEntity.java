package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.RoleEnum;

import javax.persistence.*;

@Table
@Entity(name = "roles")
public class RoleEntity extends BaseEntity{


    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    public RoleEnum getName() {
        return name;
    }

    public RoleEntity setName(RoleEnum name) {
        this.name = name;
        return this;
    }
}
