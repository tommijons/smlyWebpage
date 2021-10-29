package is.hi.quiz.Persistance.Entities;

import java.util.Timer;
// Todo implement with category entity and questions
public class Quiz {
    long ID;
    Category category;
    Timer timer;
    int noOfPlayers;

    public Quiz(Category category, Timer timer, int noOfPlayers) {
        this.category = category;
        this.timer = timer;
        this.noOfPlayers = noOfPlayers;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }
}
