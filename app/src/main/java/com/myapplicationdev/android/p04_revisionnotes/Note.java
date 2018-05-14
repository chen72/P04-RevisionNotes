package com.myapplicationdev.android.p04_revisionnotes;

public class Note {

    private int id;
    private String description;
    private int rating;

    public Note(int id, String description, int rating) {
        this.id = id;
        this.description = description;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
//What's here?

}
