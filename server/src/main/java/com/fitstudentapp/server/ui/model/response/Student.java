package com.fitstudentapp.server.ui.model.response;

import com.fitstudentapp.server.ui.model.request.StudentRequestModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    private String id;

    private String name;

    private String email;

    @Transient
    private Integer age;

    private LocalDate dob;

    public Student() {}

    public Student(String id, StudentRequestModel student) {
        this.id = id;
        this.name = student.getName();
        this.email = student.getEmail();
        this.dob = student.getDob();
    }

    public Student(String id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
