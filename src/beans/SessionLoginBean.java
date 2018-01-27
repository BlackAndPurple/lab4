package beans;

import models.Users;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless(name = "SessionLoginEJB")
public class SessionLoginBean implements ILogin{

    @PersistenceUnit
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public SessionLoginBean() {
    }

    @Override
    public boolean loginExists(String login) {
        boolean result = true;
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select users from Users users where users.login=" + "\'"+login+"\'");
        List<Users> users = query.getResultList();
        if ((users == null) || (users.size() == 0))
            result = false;
        em.close();
        return result;
    }

    @Override
    public boolean userExists(String login, String password) {
        boolean result = true;
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select users from Users users where users.login = " +"\'" + login + "\'"+" and users.password = " + password.hashCode());
        List<Users> users = query.getResultList();
        if ((users == null) || (users.size() == 0))
            result = false;
        em.close();
        return result;
    }

    @Override
    public void addUser(String login, String password) {
        EntityManager em = emf.createEntityManager();
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password.hashCode());
        em.persist(user);
        em.close();
    }
}
