package is.hi.smlyweb.Persistance.Entities;
import javax.persistence.*;
@Entity
@Table(name="scores")
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @Column(name="username")
    private String username;
    @Column(name="score")
    private int score;

    public Scores(String username, int score) {
        this.username = username;
        this.score = score;
    }

    public Scores() {

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
