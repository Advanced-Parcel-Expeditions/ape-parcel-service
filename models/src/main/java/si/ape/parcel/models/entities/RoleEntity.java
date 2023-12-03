package si.ape.parcel.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "role")
@NamedQueries(value =
        {
                @NamedQuery(name = "RoleEntity.getAll",
                        query = "SELECT r FROM RoleEntity r")
        })

public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name")
    private String role_name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

}
