package si.ape.parcel.models.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "job")
@NamedQueries(value =
        {
                @NamedQuery(name = "JobEntity.getAll",
                        query = "SELECT j FROM JobEntity j")
        })

public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date_created")
    private Instant date_created;

    @Column(name = "date_completed")
    private Instant date_completed;

    @OneToOne
    @JoinColumn(name = "job_type_id")
    private JobTypeEntity job_type;

    @OneToOne
    @JoinColumn(name = "job_status_id")
    private JobStatusEntity job_status;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private StaffEntity staff;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getDate_created() {
        return date_created;
    }

    public void setDate_created(Instant date_created) {
        this.date_created = date_created;
    }

    public Instant getDate_completed() {
        return date_completed;
    }

    public void setDate_completed(Instant date_completed) {
        this.date_completed = date_completed;
    }

    public JobTypeEntity getJob_type() {
        return job_type;
    }

    public void setJob_type(JobTypeEntity job_type) {
        this.job_type = job_type;
    }

    public JobStatusEntity getJob_status() {
        return job_status;
    }

    public void setJob_status(JobStatusEntity job_status) {
        this.job_status = job_status;
    }

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }
}
