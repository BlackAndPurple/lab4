package beans;

import models.Users;

import javax.ejb.Local;

@Local
public interface ICheck {
    boolean inArea(float x, float y, float r);
    void addToDB(Users user, float x, float y, float r, boolean result);
    void clearDB();
    Users findUserByLogin(String login);
}
