package bg.softUni.mobilele.model.dto;

import bg.softUni.mobilele.model.enums.EngineEnum;
import bg.softUni.mobilele.model.enums.TransmissionEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddOfferDto {

    @NotNull
    @Min(1)
    private Long modelId;

    @Positive
    @NotNull
    private Integer price;

    @Min(1900)
    @NotNull
    private Integer year;

    @NotNull
    private String description;

    private Integer mileage;

    @NotNull
    private EngineEnum engine;

    @NotEmpty
    private String imageUrl;

    @NotNull
    private TransmissionEnum transmission;

    public Long getModelId() {
        return modelId;
    }

    public AddOfferDto setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public AddOfferDto setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public AddOfferDto setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AddOfferDto setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDto setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public AddOfferDto setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }
}
