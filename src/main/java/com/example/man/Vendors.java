package com.example.man;

import java.sql.Date;

public class Vendors {

        private String firstName;
        private String lastName;
        private Date dateOfRegister;
        private Date dateOfBirth;
        private String location;

        // Constructor, getters, and setters


    public Vendors(String firstName, String lastName, Date dateOfRegister, Date dateOfBirth, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfRegister = dateOfRegister;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfRegister(Date dateOfRegister) {
        this.dateOfRegister = dateOfRegister;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
