package org.example.alexanderspetitions;

public class Signature {

    private String name;
    private String email;

    //Constructor
    public Signature(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //Set the name
    public void setName(String name) {
        this.name = name;
    }

    //Set the email
    public void setEmail(String email) {
        this.email = email;
    }

    //returns a given name
    public String getName() {
        return name;
    }

    //returns a given email
    public String getEmail() {
        return email;
    }
}
