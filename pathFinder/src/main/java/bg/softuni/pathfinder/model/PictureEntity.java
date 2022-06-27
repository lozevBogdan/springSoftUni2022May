package bg.softuni.pathfinder.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {

    private String title;

    private String url;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private RouteEntity route;
}
