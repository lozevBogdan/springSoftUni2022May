package bg.softUni.mobilele.model.entity;

import bg.softUni.mobilele.model.enums.EngineEnum;
import bg.softUni.mobilele.model.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity {

    private String description;
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    private String imageUrl;
    private Integer mileage;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    private Integer year;
    private Instant created;
    private Instant modified;

    @ManyToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity seller;

    public OfferEntity() {
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(Integer mileage) {
        this.mileage = mileage;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferEntity setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public OfferEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public OfferEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }
}
