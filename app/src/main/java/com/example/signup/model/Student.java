package com.example.signup.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String email;
    private String password;
    private String confirm;
    private String birth;
    private String city;
    private String country;
    private boolean isMale;
    private boolean isFemale;
    private boolean isBeginner;
    private boolean isAdvance;
    private boolean hasCricket;
    private boolean hasHockey;
    private boolean hasFootball;
    private boolean acceptsTerms;

    private List<String> selectedSports = new ArrayList<>();
    private String selectedSkills; // Store selected skills in a readable format
    private String gender; // Store selected gender in a readable format


    public Student(String name, String email, String password, String confirm,
                   String birth, String city, String country, boolean isMale,
                   boolean isFemale, boolean isBeginner, boolean isAdvance,
                   boolean hasCricket, boolean hasHockey, boolean hasFootball,
                   boolean acceptsTerms) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm = confirm;  // Adjusted to match the usage
        this.birth = birth;
        this.city = city;
        this.country = country;
        this.isMale = isMale;
        this.isFemale = isFemale;
        this.isBeginner = isBeginner;
        this.isAdvance = isAdvance;
        this.hasCricket = hasCricket;
        this.hasHockey = hasHockey;
        this.hasFootball = hasFootball;
        this.acceptsTerms = acceptsTerms;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    public boolean isBeginner() {
        return isBeginner;
    }

    public void setBeginner(boolean beginner) {
        isBeginner = beginner;
    }

    public boolean isAdvance() {
        return isAdvance;
    }

    public void setAdvance(boolean advance) {
        isAdvance = advance;
    }

    public boolean isHasCricket() {
        return hasCricket;
    }

    public void setHasCricket(boolean hasCricket) {
        this.hasCricket = hasCricket;
    }

    public boolean isHasHockey() {
        return hasHockey;
    }

    public void setHasHockey(boolean hasHockey) {
        this.hasHockey = hasHockey;
    }

    public boolean isHasFootball() {
        return hasFootball;
    }

    public void setHasFootball(boolean hasFootball) {
        this.hasFootball = hasFootball;
    }

    public boolean isAcceptsTerms() {
        return acceptsTerms;
    }

    public void setAcceptsTerms(boolean acceptsTerms) {
        this.acceptsTerms = acceptsTerms;
    }



}
