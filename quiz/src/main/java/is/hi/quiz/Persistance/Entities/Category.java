package is.hi.quiz.Persistance.Entities;

import java.util.ArrayList;
import java.util.List;
//import javax.persistence.*;

//@Entity
public class Category {
    public long ID;
    // public for now
    public String categoryName;
    public int categoryID;
    //private List<Question> questions = new ArrayList<>();

    public Category(int categoryID, String categoryName) {
        this.categoryID =categoryID;
        this.categoryName=categoryName;
        //this.questions = questions;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    /*public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }*/
}
