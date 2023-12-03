package si.ape.parcel.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "branch")
@NamedQueries(value =
        {
                @NamedQuery(name = "BranchEntity.getAll",
                        query = "SELECT b FROM BranchEntity b")
        })

public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "branch_type_id")
    private BranchTypeEntity branch_type;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "street_name", referencedColumnName = "street_name"),
            @JoinColumn(name = "street_number", referencedColumnName = "street_number"),
            @JoinColumn(name = "city_code", referencedColumnName = "city_code"),
            @JoinColumn(name = "city_name", referencedColumnName = "city_name"),
            @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    })
    private StreetEntity street;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BranchTypeEntity getBranch_type() {
        return branch_type;
    }

    public void setBranch_type(BranchTypeEntity branch_type) {
        this.branch_type = branch_type;
    }

    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
    }
}
