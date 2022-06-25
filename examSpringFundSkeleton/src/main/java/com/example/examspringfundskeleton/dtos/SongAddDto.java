package com.example.examspringfundskeleton.dtos;

import com.example.examspringfundskeleton.entity.StyleEntity;
import com.example.examspringfundskeleton.entity.StyleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.util.Date;

public class SongAddDto {


    @NotNull
    @Size(min = 3,max = 20)
    private String performer;

    @NotNull
    @Size(min = 2,max = 20)
    private String title;

    @NotNull
    @Positive
    private Integer duration;

    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @NotNull
    private StyleEnum style;

    public String getPerformer() {
        return performer;
    }

    public SongAddDto setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongAddDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDuration() {
        return duration;
    }

    public SongAddDto setDuration(Integer duration) {
        this.duration = duration;
        return this;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public SongAddDto setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public StyleEnum getStyle() {
        return style;
    }

    public SongAddDto setStyle(StyleEnum style) {
        this.style = style;
        return this;
    }

    @Override
    public String toString() {
        return "SongAddDto{" +
                "performer='" + performer + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", style=" + style +
                '}';
    }
}
