package beans;

import models.*;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Stateless(name = "SessionDataGetterEJB")
public class SessionDataGetterBean implements IDataGetter{

    @PersistenceUnit
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public SessionDataGetterBean() {
    }

    @Override
    public List<People> getPeople(){
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select people from People people");
        List<People> people = query.getResultList();
        em.close();
        return people;
    }


    @Override
    public List<Parent> getParents() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select parent from Parent parent");
        List<Parent> parents = query.getResultList();
        em.close();
        return parents;
    }

    @Override
    public String determineType(String Person_id) {
        if (Person_id == null)
            return "no person_id";
        String retString = null;
        long person_id = Long.parseLong(Person_id);
        boolean parent_flag = true, staff_flag = true;
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select parent from Parent parent where parent.person.person_id = " + person_id);
        try {
            Object o = query.getSingleResult();
        }catch (NoResultException e){
            parent_flag = false;
        }
        Query query1 = em.createQuery("select staff from Staff staff where staff.person.person_id = " + person_id);
        try {
            Object o1 = query1.getSingleResult();
        }catch (NoResultException e){
            staff_flag = false;
        }
        if (parent_flag){
            if (staff_flag)
                retString = "Parent/Staff";
            else retString = "Parent";
        }else {if (staff_flag)
            retString = "Staff";
        else retString = "There's no such ID among parents and staff";}
        em.close();
        return retString;
    }

    @Override
    public List<Kid> getChildren(String Parent_id) {
        long parent_id = Long.parseLong(Parent_id);
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select kid from Kid kid where kid.parent1.parent_id = " + parent_id + " or " + "kid.parent2.parent_id = "+parent_id);
        List<Kid> children = query.getResultList();
        em.close();
        return children;
    }

    @Override
    public List<Kid> getKidsInGroup(String groupName) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select kidAc.kid from KidAccount kidAc where kidAc.group.name = \'" + groupName + "\'");
        List<Kid> kids = query.getResultList();
        em.close();
        return kids;
    }

    @Override
    public List<ParentContacts> getContacts() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT contacts from ParentContacts contacts");
        List<ParentContacts> contacts = query.getResultList();
        em.close();
        return contacts;
    }

    @Override
    public List<Kid> getKids() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT kids from Kid kids");
        List<Kid> kids = query.getResultList();
        em.close();
        return kids;
    }

    @Override
    public List<KidAccount> getKidAccounts() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT accounts from KidAccount accounts");
        List<KidAccount> accounts = query.getResultList();
        em.close();
        return accounts;
    }

    @Override
    public List<MedInfo> getMedInfo() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT med from MedInfo med");
        List<MedInfo> meds = query.getResultList();
        em.close();
        return meds;
    }

    @Override
    public List<Group> getGroups() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT groups from Group groups");
        List<Group> groups = query.getResultList();
        em.close();
        return groups;
    }

    @Override
    public List<Staff> getStaff() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT staff from Staff staff");
        List<Staff> staff = query.getResultList();
        em.close();
        return staff;
    }

    @Override
    public List<StaffGroup> getStaffGroup() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT staff from StaffGroup staff");
        List<StaffGroup> staff = query.getResultList();
        em.close();
        return staff;
    }

    @Override
    public void addPerson(String name, String middleName, String surname, boolean sex, Date dateOfBirth) {
        EntityManager em = emf.createEntityManager();
        People person = new People();
        person.setName(name);
        person.setMiddleName(middleName);
        person.setSurname(surname);
        person.setSex(sex);
        person.setDate_of_birth(dateOfBirth);;
        em.persist(person);
        em.close();
    }


    @Override
    public void addParent(long person_id) {
        EntityManager em = emf.createEntityManager();
        Parent parent = new Parent();
        Query query = em.createQuery("SELECT person from People person where person.person_id=" + person_id);
        People person = (People)query.getSingleResult();
        parent.setPerson(person);
        parent.setPerson_id();
        em.persist(parent);
        em.close();
    }

    @Override
    public void addContacts(long parent_id, Date dateOfCreating, String homeAddress, String job, String jobPhoneNumber, String cellPhoneNumber) {
        EntityManager em = emf.createEntityManager();
        ParentContacts contacts = new ParentContacts();
        contacts.setDate_of_creating(dateOfCreating);
        contacts.setHomeAddress(homeAddress);
        contacts.setJob(job);
        contacts.setJobPhoneNumber(jobPhoneNumber);
        contacts.setCellphoneNumber(cellPhoneNumber);
        Query query = em.createQuery("SELECT parent from Parent parent where parent.parent_id=" + parent_id);
        Parent parent = (Parent) query.getSingleResult();
        parent.getParentContacts().add(contacts);
        contacts.setParent(parent);
        em.persist(contacts);
        em.close();
    }

    @Override
    public void addKid(long person_id, long parent1_id, long parent2_id) {
        EntityManager em = emf.createEntityManager();
        Kid kid = new Kid();
        Parent parent1 = null, parent2 = null;
        if (person_id != 0){
            Query query1 = em.createQuery("SELECT person from People person where person.person_id=" + person_id);
            People person = (People) query1.getSingleResult();
            kid.setPerson(person);
        }

        if (parent1_id != 0){
            Query query2 = em.createQuery("SELECT parent from Parent parent where parent.parent_id=" + parent1_id);
            try{
                parent1 = (Parent) query2.getSingleResult();
            }catch (Exception e){ }
            kid.setParent1(parent1);
        }

        //if (parent2_id != 0){
       /* if(parent2_id == 0)
            kid.setParent2(null);
        else{*/
            try {

                Query query3 = em.createQuery("SELECT parent from Parent parent where parent.parent_id=" + parent2_id);
                parent2 = (Parent) query3.getSingleResult();
                kid.setParent2(parent2);
            }catch (Exception e){}
       // }



        em.persist(kid);
        em.close();
    }
}
