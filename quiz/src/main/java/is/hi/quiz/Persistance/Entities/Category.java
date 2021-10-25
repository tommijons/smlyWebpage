package is.hi.quiz.Persistance.Entities;

import java.util.ArrayList;
import java.util.List;
//import javax.persistence.*;

//@Entity
public class Category {
    private int id;
    private String categoryName;
    //private List<Question> questions = new ArrayList<>();

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName=categoryName;
        //this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }*/
}
