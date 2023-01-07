package com.dsoumaila.sendmail.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "user")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Constructor with parameters
     *
     * @param firstName the first name of user.
     * @param lastName  the last name of user.
     * @param email     the email of user.
     */
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
