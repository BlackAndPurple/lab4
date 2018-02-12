package beans;

import models.CheckResults;
import models.Users;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless(name = "SessionCheckEJB")
public class SessionCheckBean implements ICheck{

    @PersistenceUnit
    public EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

    public SessionCheckBean() {
    }

    @Override
    public boolean inArea(float x, float y, float r) {
        boolean b1 = (x <= 0)&&(x >= -r)&&(y >= 0)&&(y <= r);
        boolean b2 = (x <= 0)&&(y <= 0)&&(y >= -2*x -2);
        boolean b3 = (x >= 0)&&(y >= 0)&&(Math.sqrt(x*x + y*y) <= r);
        return b1 || b2 || b3;
    }

    @Override
    public void addToDB(Users user, float x, float y, float r, boolean result) {
        EntityManager em = emf.createEntityManager();
        CheckResults check = new CheckResults();
        check.setUser(user);
        check.setX(x);
        check.setY(y);
        check.setR(r);
        check.setResult(result);
        em.persist(check);
    }

    @Override
    public Users findUserByLogin(String login) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select user from Users user");
        List<Users> usersList = query.getResultList();
        for (Users user : usersList)
            if (user.getLogin().equals(login))
                return user;
        return null;
    }

    @Override
    public void clearDB() {

    }
}
