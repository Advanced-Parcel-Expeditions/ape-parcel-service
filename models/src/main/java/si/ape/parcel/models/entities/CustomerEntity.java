package si.ape.parcel.models.entities;

import javax.persistence.*;


@Entity
@Table(name = "customer")
@NamedQueries(value =
        {
                @NamedQuery(name = "CustomerEntity.getAll",
                        query = "SELECT c FROM CustomerEntity c")
        })

public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "tel_num")
    private String tel_num;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "street_name", referencedColumnName = "street_name"),
            @JoinColumn(name = "street_number", referencedColumnName = "street_number"),
            @JoinColumn(name = "city_code", referencedColumnName = "city_code"),
            @JoinColumn(name = "city_name", referencedColumnName = "city_name"),
            @JoinColumn(name = "country_code", referencedColumnName = "country_code")
    })
    private StreetEntity street;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

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

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTel_num() {
        return tel_num;
    }

    public void setTel_num(String tel_num) {
        this.tel_num = tel_num;
    }

    public StreetEntity getStreet() {
        return street;
    }

    public void setStreet(StreetEntity street) {
        this.street = street;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
