package is.hi.quiz.Persistance.Entities;

import java.util.ArrayList;
import java.util.List;
//import javax.persistence.*;

//@Entity
public class Category {
    private long ID;
    private String categoryName;
    private int categoryID;
    private List<Question> questions;

    public Category(int categoryID, String categoryName, List<Question> questions) {
        this.categoryName = categoryName;
        this.categoryID = categoryID;
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
