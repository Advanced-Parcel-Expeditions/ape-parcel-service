package si.ape.parcel.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "message")
@NamedQueries(value =
        {
                @NamedQuery(name = "MessageEntity.getAll",
                        query = "SELECT m FROM MessageEntity m")
        })

public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer message_id;

    @Column(name = "sent_at")
    private Instant sent_at;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "conversation_id", referencedColumnName = "id")
    private ConversationEntity conversation;

    public Integer getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public Instant getSent_at() {
        return sent_at;
    }

    public void setSent_at(Instant sent_at) {
        this.sent_at = sent_at;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ConversationEntity getConversation() {
        return conversation;
    }

    public void setConversation(ConversationEntity conversation) {
        this.conversation = conversation;
    }
}
