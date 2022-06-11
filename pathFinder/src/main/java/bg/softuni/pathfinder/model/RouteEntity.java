package bg.softuni.pathfinder.model;

import java.util.List;
import bg.softuni.pathfinder.model.enums.LevelEnum;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class RouteEntity extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT ")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    private UserEntity author;

    private String videoUrl;

    @ManyToMany
    private List<CategoryEntity> categories;

    @OneToMany(
            mappedBy = "route", targetEntity = PictureEntity.class,
            fetch = FetchType.LAZY,cascade = CascadeType.ALL
    )
    private List<PictureEntity> pictures;

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public RouteEntity setGpxCoordinates(String coordinates) {
        this.gpxCoordinates = coordinates;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public RouteEntity setVideoUrl(String url) {
        this.videoUrl = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RouteEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public RouteEntity setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
        return this;
    }

    public List<PictureEntity> getPictures() {
        return pictures;
    }

    public RouteEntity setPictures(List<PictureEntity> pictures) {
        this.pictures = pictures;
        return this;
    }
}
