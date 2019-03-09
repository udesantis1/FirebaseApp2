package com.example.firebaseapp;

public class Rating {

    float valuee;
    String ratingID;
    public Rating(){

    }

    public Rating(String ratingID,float valuee) {
        this.valuee = valuee;
        this.ratingID=ratingID;
    }

    public String getRatingID() {
        return ratingID;
    }

    public float getValuee() {
        return valuee;
    }
}
