package bg.softUni.mobilele.model.entity;

import bg.softUni.mobilele.model.enums.RoleEnum;

import javax.persistence.*;
import java.util.*;
import java.time.Instant;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private String username;
    private String password;
    private String firstname;
    private String lastName;
    private boolean isActive;
    @ManyToOne(fetch = FetchType.EAGER)
    private UserRoleEntity role ;
    private String imageUrl;
    private Instant created;
    private Instant modified;
    @OneToMany(mappedBy = "seller")
    private List<OfferEntity> offers;

    public UserEntity() {
    }

    public List<OfferEntity> getOffers() {
        return offers;
    }

    public UserEntity setOffers(List<OfferEntity> offers) {
        this.offers = offers;
        return this;
    }

    public UserRoleEntity getRole() {
        return role;
    }

    public UserEntity setRole(UserRoleEntity role) {
        this.role = role;
        return this;
    }

    public String getUsername() {
        return username;
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

    public String getFirstname() {
        return firstname;
    }

    public UserEntity setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public UserEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public UserEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public UserEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }
}
