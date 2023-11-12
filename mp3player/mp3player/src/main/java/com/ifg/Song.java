package com.ifg;

import java.io.File;

public class Song {

    private String path;
    private String title;
    private String artist;

    public Song(String path) {
        this.path = path;
        this.title = new File(path).getName().substring(0, new File(path).getName().lastIndexOf("."));
        this.artist = new File(path).getName().substring(new File(path).getName().lastIndexOf(".") + 1);
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
