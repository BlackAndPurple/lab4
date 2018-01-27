package models;

import javax.naming.NameAlreadyBoundException;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PARENT_CONTACTS", schema = "s225128")
public class ParentContacts {

    @Id
    private long contacts_id;
    //private int parent_id;

    @Temporal(TemporalType.DATE)
    private Date date_of_creating;

    @Column(name="HOME_ADDRESS", columnDefinition = "VARCHAR(200)")
    private String homeAddress;

    @Column(columnDefinition = "VARCHAR(200)")
    private String job;

    @Column(name = "JOB_PHONE_NUMBER", columnDefinition = "VARCHAR(30)")
    private String jobPhoneNumber;

    @Column(name="CELL_PHONE_NUMBER", columnDefinition = "VARCHAR(30)")
    private String cellphoneNumber;

    @ManyToOne
    @JoinColumn(name="PARENT_ID", referencedColumnName = "parent_id", insertable = false) //used to be name="PARENT_ID" and it didnt work
    private Parent parent;

    public long getContacts_id() {
        return contacts_id;
    }

    public void setContacts_id(long contacts_id) {
        this.contacts_id = contacts_id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Date getDate_of_creating() {
        return date_of_creating;
    }

    public void setDate_of_creating(Date date_of_creating) {
        this.date_of_creating = date_of_creating;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJobPhoneNumber() {
        return jobPhoneNumber;
    }

    public void setJobPhoneNumber(String jobPhoneNumber) {
        this.jobPhoneNumber = jobPhoneNumber;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }
}
