package com.example.alma19.myapplication;

/**
 * Created by alma19 on 11/16/16.
 */

public class UserInformation {
    public String name;
    public String age;
    public String gender;
    public String quote;
    public String facebook;
    public String twitter;
    public String instagram;
    public String email;

    public UserInformation(){

    }

    public UserInformation(String name, String age, String gender, String quote, String facebook, String twitter, String instagram, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.quote = quote;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}




