package models;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "s225128")
public class Users {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "IdSeq")
    @SequenceGenerator(name="IdSeq",sequenceName="s225128.users_ids", allocationSize=1)
    private long id;

    @Column(name="login", columnDefinition = "VARCHAR(30)")
    private String login;

    private long password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }
}
