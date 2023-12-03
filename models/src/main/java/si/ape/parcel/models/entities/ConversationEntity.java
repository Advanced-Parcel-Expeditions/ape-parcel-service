package si.ape.parcel.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "conversation")
@NamedQueries(value =
        {
                @NamedQuery(name = "ConversationEntity.getAll",
                        query = "SELECT c FROM ConversationEntity c")
        })

public class ConversationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "created_at")
    private Instant created_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String weight) {
        this.name = name;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

}
