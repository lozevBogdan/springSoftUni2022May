package bg.softUni.mobilele.model.entity;

import java.util.List;
import org.hibernate.engine.spi.CascadeStyles;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    private Instant created;

    private Instant modified;

    @OneToMany(mappedBy = "brand",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<ModelEntity> models;

    public BrandEntity() {
    }

    public Instant getCreated() {
        return created;
    }

    public BrandEntity setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public BrandEntity setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public List<ModelEntity> getModels() {
        return models;
    }

    public BrandEntity setModels(List<ModelEntity> models) {
        this.models = models;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandEntity setName(String name) {
        this.name = name;
        return this;
    }

    @PrePersist
    public void beforeCreate(){
        this.created = Instant.now();
    }




}
