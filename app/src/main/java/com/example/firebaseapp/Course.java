package com.example.firebaseapp;


public class Course {

    public String courseName;

    public Course() {

    }

    public Course(String courseName) {
        this.courseName = courseName;

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}