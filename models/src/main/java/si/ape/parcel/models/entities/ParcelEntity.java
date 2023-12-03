package si.ape.parcel.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "parcel")
@NamedQueries(value =
        {
                @NamedQuery(name = "ParcelEntity.getAll",
                        query = "SELECT p FROM ParcelEntity p")
        })
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "width")
    private Integer width;

    @Column(name = "height")
    private Integer height;

    @Column(name = "depth")
    private Integer depth;

    @OneToOne
    @JoinColumn(name = "parcel_status_id")
    private ParcelStatusEntity parcel_status;

    @OneToOne
    @JoinColumn(name = "sender_id")
    private CustomerEntity sender;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "sender_street_name", referencedColumnName = "street_name"),
            @JoinColumn(name = "sender_street_number", referencedColumnName = "street_number"),
            @JoinColumn(name = "sender_city_code", referencedColumnName = "city_code"),
            @JoinColumn(name = "sender_city_name", referencedColumnName = "city_name"),
            @JoinColumn(name = "sender_country_code", referencedColumnName = "country_code")
    })
    private StreetEntity sender_street;

    @OneToOne
    @JoinColumn(name = "recipient_id")
    private CustomerEntity recipient;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "recipient_street_name", referencedColumnName = "street_name"),
            @JoinColumn(name = "recipient_street_number", referencedColumnName = "street_number"),
            @JoinColumn(name = "recipient_city_code", referencedColumnName = "city_code"),
            @JoinColumn(name = "recipient_city_name", referencedColumnName = "city_name"),
            @JoinColumn(name = "recipient_country_code", referencedColumnName = "country_code")
    })
    private StreetEntity recipient_street;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDepth() {
        return depth;
    }

    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    public ParcelStatusEntity getParcel_status() {
        return parcel_status;
    }

    public void setParcel_status(ParcelStatusEntity parcel_status) {
        this.parcel_status = parcel_status;
    }

    public CustomerEntity getSender() {
        return sender;
    }

    public void setSender(CustomerEntity sender) {
        this.sender = sender;
    }

    public StreetEntity getSender_street() {
        return sender_street;
    }

    public void setSender_street(StreetEntity sender_street) {
        this.sender_street = sender_street;
    }

    public CustomerEntity getRecipient() {
        return recipient;
    }

    public void setRecipient(CustomerEntity recipient) {
        this.recipient = recipient;
    }

    public StreetEntity getRecipient_street() {
        return recipient_street;
    }

    public void setRecipient_street(StreetEntity recipient_street) {
        this.recipient_street = recipient_street;
    }
}