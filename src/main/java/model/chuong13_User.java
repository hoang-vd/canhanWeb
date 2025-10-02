package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "chuong13_User")
// Map to existing PostgreSQL table as provided: public.User (case-sensitive)
// If the table was created without quotes, change to @Table(name = "user") and
// adjust the @Column names to lowercase (userid, email, firstname, lastname).
@Table(name = "\"User\"")
public class chuong13_User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "Email", length = 255, unique = false) // add unique constraint in DB if required
    private String email;

    @Column(name = "FirstName", length = 100)
    private String firstName;

    @Column(name = "LastName", length = 100)
    private String lastName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
}