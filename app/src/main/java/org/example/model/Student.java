package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;
@Entity
@Table(name = "Student")
public class Student {
    @Id

    private UUID StudentId;
    private String StudentName;
    private String email;
    private String passwrod;


    public Student() {
    }

    public String getStudentName() {
        return StudentName;
    }

    public UUID getStudentId() {
        return StudentId;
    }

    public void setStudentId(UUID studentId) {
        StudentId = studentId;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }
}
