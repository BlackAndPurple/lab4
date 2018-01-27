package models;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "KID", schema = "s225128")
public class Kid {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "IdSeq2")
    @SequenceGenerator(name="IdSeq2",sequenceName="kid_ids", allocationSize=1)
    private int kid_id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "person_id")
    private People person;

    @ManyToOne
    @JoinColumn(name="PARENT1_ID", referencedColumnName = "parent_id", insertable = false)
    private Parent parent1;


    @ManyToOne
    @JoinColumn(name="PARENT2_ID", referencedColumnName = "parent_id", insertable = false)
    private Parent parent2;


    @OneToMany(targetEntity = MedInfo.class, mappedBy = "kid")
    private Collection<MedInfo> medInfos;

    @OneToMany(targetEntity = KidAccount.class, mappedBy = "kid")
    private Collection<KidAccount> kidAccounts;

    public Collection<MedInfo> getMedInfos() {
        return medInfos;
    }

    public Collection<KidAccount> getKidAccounts() {
        return kidAccounts;
    }

    public void setKidAccounts(Collection<KidAccount> kidAccounts) {
        this.kidAccounts = kidAccounts;
    }

    public void setMedInfos(Collection<MedInfo> medInfos) {

        this.medInfos = medInfos;
    }

    public int getKid_id() {
        return kid_id;
    }

    public void setKid_id(int kid_id) {
        this.kid_id = kid_id;
    }

    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }

    public Parent getParent1() {
        return parent1;
    }

    public void setParent1(Parent parent1) {
        this.parent1 = parent1;
    }

    public Parent getParent2() {
        return parent2;
    }

    public void setParent2(Parent parent2) {
        this.parent2 = parent2;
    }
}
