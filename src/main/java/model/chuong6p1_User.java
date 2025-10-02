package model;

import java.io.Serializable;

public class chuong6p1_User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;

    public chuong6p1_User() {
        firstName = "";
        lastName = "";
        email = "";
    }

    public chuong6p1_User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
