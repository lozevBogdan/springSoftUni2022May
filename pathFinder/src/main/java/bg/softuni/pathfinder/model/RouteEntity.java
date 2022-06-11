package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.LevelEnum;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT ")
    private String coordinates;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    private String name;

    @ManyToOne
    private UserEntity author;

    private String url;

    public String getCoordinates() {
        return coordinates;
    }

    public RouteEntity setCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public RouteEntity setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public RouteEntity setName(String name) {
        this.name = name;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public RouteEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public RouteEntity setUrl(String url) {
        this.url = url;
        return this;
    }
}
