package beans;

import javax.ejb.Local;

@Local
public interface ILogin {

    boolean loginExists(String login);
    boolean userExists(String login, String password);
    void addUser(String login, String password);
}
