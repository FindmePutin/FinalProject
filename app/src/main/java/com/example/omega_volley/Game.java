package com.example.omega_volley;

public class Game {

    private String title, thumbnail , genre , description;

    public Game(String title, String thumbnail, String genre, String description) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.genre = genre;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }
}
