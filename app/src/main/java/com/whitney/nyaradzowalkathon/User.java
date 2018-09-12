package com.whitney.nyaradzowalkathon;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String name;
    public String phone;
    public String gender;
    public String shirtSize;
    public String emergency;
    public String email;
    public String nationality;
    public String company;

    public User() {
    }

    public User(String name, String phone, String gender, String shirtSize,
                String emergency, String email, String nationality, String company) {
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.shirtSize = shirtSize;
        this.emergency = emergency;
        this.email = email;
        this.nationality = nationality;
        this.company = company;
    }
}