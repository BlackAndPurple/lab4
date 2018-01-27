package beans;
import models.*;

import javax.ejb.Local;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Local
public interface IDataGetter {

    List<People> getPeople();
    List<Parent> getParents();
    String determineType(String Person_id);
    List<Kid> getChildren(String Parent_id);
    List<Kid> getKidsInGroup(String groupName);
    List<ParentContacts> getContacts();
    List<Kid> getKids();
    List<KidAccount> getKidAccounts();
    List<MedInfo> getMedInfo();
    List<Group> getGroups();
    List<Staff> getStaff();
    List<StaffGroup> getStaffGroup();
    void addPerson(String name, String middleName, String surname, boolean sex, Date dateOfBirth);
    void addContacts(long parent_id, Date dateOfCreating, String homeAddress, String job, String jobPhoneNumber, String cellPhoneNumber);
    void addParent(long person_id);
    void addKid(long person_id, long parent1_id, long parent2_id);
}
