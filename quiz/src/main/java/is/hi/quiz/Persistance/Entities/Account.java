package is.hi.quiz.Persistance.Entities;

import java.util.ArrayList;

public class Account {
    private long ID;
    private String userName;
    private String password;
    private String email;
    private String name;
    //private List<Scores> scores = new ArrayList<>();
    private boolean isAdmin;

    public Account(String userName, String password, String email, String name, boolean isAdmin) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.name = name;
        this.isAdmin = isAdmin;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
