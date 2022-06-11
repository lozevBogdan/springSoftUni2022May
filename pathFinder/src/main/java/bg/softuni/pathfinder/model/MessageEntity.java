package bg.softuni.pathfinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity {

    @Column(name = "date_time")
    private Instant dateTime;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private UserEntity recipient;

    public Instant getDateTime() {
        return dateTime;
    }

    public MessageEntity setDateTime(Instant dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public MessageEntity setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public UserEntity getRecipient() {
        return recipient;
    }

    public MessageEntity setRecipient(UserEntity recipient) {
        this.recipient = recipient;
        return this;
    }
}
