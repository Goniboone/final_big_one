package edu.uh.tech.cis3368.finalproject;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "job_form", schema = "public", catalog = "finalproject")
public class JobFormEntity {
    private int jobId;
    private String jobName;
    private Date completionDate;

    public JobFormEntity(){}

    public JobFormEntity(String jobName, Date completionDate){
        this.jobName = jobName;
        this.completionDate = completionDate;
    }

    public JobFormEntity(String jobName){
        this.jobName = jobName;
    }

    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_name")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Basic
    @Column(name = "completion_date")
    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobFormEntity that = (JobFormEntity) o;
        return jobId == that.jobId &&
                Objects.equals(jobName, that.jobName) &&
                Objects.equals(completionDate, that.completionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, jobName, completionDate);
    }
}
