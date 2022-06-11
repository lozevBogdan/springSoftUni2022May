package bg.softuni.pathfinder.model;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.Instant;

@Table
@Entity(name = "comments")
public class CommentEntity extends BaseEntity {

    private boolean approved;

    @PastOrPresent
    private Instant created;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;

    public boolean isApproved() {
        return approved;
    }

    public CommentEntity setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public CommentEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public CommentEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public RouteEntity getRoute() {
        return route;
    }

    public CommentEntity setRoute(RouteEntity route) {
        this.route = route;
        return this;
    }

    @PrePersist
    public void setCreatedInstantTime(){
        this.setCreated(Instant.now());
    }

}
