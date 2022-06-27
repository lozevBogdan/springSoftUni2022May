package bg.softUni.mobilele.model.entity;

import javax.persistence.*;
import java.util.*;
import java.time.Instant;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(nullable = false)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private boolean isActive;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles = new ArrayList<>();
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

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEntity> role) {
        this.roles = role;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstname) {
        this.firstName = firstname;
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

    public UserEntity addRole(UserRoleEntity userRoleEntity) {
        this.roles.add(userRoleEntity);
        return this;

    }

    @PrePersist
    public void dateAndTimeCreation() {
        this.created = Instant.now();
        System.out.println("Im in prepersist annotayion, heyyyy");
    }
}
