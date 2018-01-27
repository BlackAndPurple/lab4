package models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PARENT", schema = "s225128")
public class Parent {

    @Id
    @Column(name = "PARENT_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "IdSeq1")
    @SequenceGenerator(name="IdSeq1",sequenceName="parent_ids", allocationSize=1)
    private long parent_id;

    @OneToOne
    @PrimaryKeyJoinColumn(name = "person_id", referencedColumnName = "person_id")
    private People person;

    @OneToMany(targetEntity = ParentContacts.class, mappedBy = "parent")
    private Collection<ParentContacts> parentContacts;

    /*@OneToMany(targetEntity = Kid.class, mappedBy = "parent1")
    private Collection<Kid> kids;*/

    public long getParent_id() {
        return parent_id;
    }

    public void setParent_id(long parent_id) {
        this.parent_id = parent_id;
    }

    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }
}
