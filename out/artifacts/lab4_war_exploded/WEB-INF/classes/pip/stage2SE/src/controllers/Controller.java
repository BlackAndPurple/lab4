package controllers;

import models.*;

import javax.persistence.*;
import java.util.List;

public class Controller {
    @PersistenceUnit
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public void doSmthWithDB(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Query query2 = em.createQuery("SELECT var from StaffGroup var");
        List<StaffGroup> resList2 = query2.getResultList();
        for (StaffGroup var : resList2)
            System.out.println(var.getId()+" "+var.getGroup().getName()+" "+var.getStaff().getPerson().getName());

        tx.commit();
        em.close();
    }
}
