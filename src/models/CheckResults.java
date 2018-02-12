package models;

import javax.persistence.*;

@Entity
@Table(name = "checks", schema = "s225128")
public class CheckResults {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "IdSeq2")
    @SequenceGenerator(name="IdSeq2",sequenceName="s225128.check_ids", allocationSize=1)
    private long check_id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    Users user;

    private float x;
    private float y;
    private float r;
    private boolean result;

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
