package si.ape.parcel.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "branch_type")
@NamedQueries(value =
        {
                @NamedQuery(name = "BranchTypeEntity.getAll",
                        query = "SELECT b FROM BranchTypeEntity b")
        })

public class BranchTypeEntity {
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
