package si.ape.parcel.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "job_status")
@NamedQueries(value =
        {
                @NamedQuery(name = "JobStatusEntity.getAll",
                        query = "SELECT j FROM JobStatusEntity j")
        })

public class JobStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

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
}