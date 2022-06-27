package com.example.examspringfundskeleton.dtos;

import com.example.examspringfundskeleton.entity.StyleEntity;
import com.example.examspringfundskeleton.entity.StyleEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class SongsViewDto {

    private Long id;
    private String performer;
    private String title;
    private String durationInMin;
    private StyleEntity style;

    public Long getId() {
        return id;
    }

    public StyleEntity getStyle() {
        return style;
    }

    public SongsViewDto setStyle(StyleEntity style) {
        this.style = style;
        return this;
    }

    public SongsViewDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongsViewDto setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongsViewDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDurationInMin() {
        return durationInMin;
    }

    public SongsViewDto setDurationInMin(String durationInMin) {
        this.durationInMin = durationInMin;
        return this;
    }
}
