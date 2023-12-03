package si.ape.parcel.models.entities;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "job_packet")
@NamedQueries(value =
        {
                @NamedQuery(name = "JobPacketEntity.getAll",
                        query = "SELECT j FROM JobPacketEntity j")
        })

@IdClass(JobPacketEntity.JobPacketId.class)
public class JobPacketEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobEntity job;

    @Id
    @ManyToOne
    @JoinColumn(name = "parcel_id")
    private ParcelEntity parcel;

    public static class JobPacketId implements Serializable {
        private JobEntity job;
        private ParcelEntity parcel;

        public JobPacketId(JobEntity job, ParcelEntity parcel) {
            this.job = job;
            this.parcel = parcel;
        }

        public JobEntity getJob() {
            return job;
        }

        public void setJob(JobEntity job) {
            this.job = job;
        }

        public ParcelEntity getParcel() {
            return parcel;
        }

        public void setParcel(ParcelEntity parcel) {
            this.parcel = parcel;
        }
    }

    public JobEntity getJob() {
        return job;
    }

    public void setJob(JobEntity job) {
        this.job = job;
    }

    public ParcelEntity getParcel() {
        return parcel;
    }

    public void setParcel(ParcelEntity parcel) {
        this.parcel = parcel;
    }
}
