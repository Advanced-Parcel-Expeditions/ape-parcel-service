package si.ape.parcel.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "staff")
@NamedQueries(value =
        {
                @NamedQuery(name = "StaffEntity.getAll",
                        query = "SELECT s FROM StaffEntity s")
        })

public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchEntity branch_id;

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public BranchEntity getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(BranchEntity branch_id) {
        this.branch_id = branch_id;
    }
}
