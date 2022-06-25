package com.example.examspringfundskeleton.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "song")
@Entity
public class SongEntity extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String performer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer duration;

    private Date releaseDate;

    @ManyToOne
    private StyleEntity style;

    public String getPerformer() {
        return performer;
    }



    public SongEntity setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongEntity setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public SongEntity setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleEntity getStyle() {
        return style;
    }

    public SongEntity setStyle(StyleEntity style) {
        this.style = style;
        return this;
    }
}
