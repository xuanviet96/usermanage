package com.demo.usermanage.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usertable")
public class User {

    //primary key
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column( name = "id", nullable = false)
    private Integer id = 0;

    @NotEmpty()
    @Column( name = "first_name", nullable=false, length=30)
    private String firstName;

    @NotEmpty()
    @Column( name = "last_name", nullable=false, length=30)
    private String lastName;

    @Email
    @Column(name = "email", nullable=false, length=50)
    private String email;
    @NotEmpty()
    @Column(name = "age", nullable=false, length=10)
    private int age;

    public User(){

    }
    public User(int id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age =age;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
