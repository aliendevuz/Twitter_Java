package com.example.twitterjava.model;

public class Post {

    public int profile;
    public String name;
    public int[] photos;
    public String video = "";

    public Post(int profile, String name, int[] photos) {
        this.profile = profile;
        this.name = name;
        this.photos = photos;
    }

    public Post(int profile, String name, String video) {
        this.profile = profile;
        this.name = name;
        this.video = video;
    }
}
