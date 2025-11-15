package org.example.alexanderspetitions;

import java.util.ArrayList;
import java.util.List;

public class Petition {

    private String title;
    private String description;
    private List<Signature> signatures = new ArrayList<Signature>();

    //Constructor
    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
    }

    //returns a given title
    public String getTitle() { return title; }

    //Sets a title
    public void setTitle(String title) {
        this.title = title;
    }

    //Gets a description
    public String getDescription() { return this.description; }

    //Sets a description
    public void setDescription(String description) {
        this.description = description;
    }

    //Creates a list of signatures
    public List<Signature> getSignatures() { return this.signatures; }

    //Adds a signature to the list of signatures
    public void addSignature(Signature signature) {
        this.signatures.add(signature);
    }


}
