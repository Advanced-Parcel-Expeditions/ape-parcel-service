package si.ape.parcel.models.entities;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_conversation")
@NamedQueries(value =
        {
                @NamedQuery(name = "UserConversationEntity.getAll",
                        query = "SELECT u FROM UserConversationEntity u")
        })

@IdClass(UserConversationEntity.UserConversationId.class)
public class UserConversationEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Id
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private ConversationEntity conversation;

    public static class UserConversationId implements Serializable {
        private UserEntity user;
        private ConversationEntity conversation;

        public UserConversationId(UserEntity user, ConversationEntity conversation) {
            this.user = user;
            this.conversation = conversation;
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
