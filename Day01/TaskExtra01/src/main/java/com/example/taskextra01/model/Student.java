package com.example.taskextra01.model;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String phoneNumber;

    public Student() {
    }

    public Student(int studentId, String name, String email, String phoneNumber) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
