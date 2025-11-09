package org.example.alexanderspetitions;

public class Petition {

    private String title;
    private String description;

    public Petition(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() { return this.description; }

    public void setDescription(String description) {
        this.description = description;
    }


}
