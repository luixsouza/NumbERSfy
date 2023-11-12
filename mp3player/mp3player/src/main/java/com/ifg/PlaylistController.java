package com.ifg;

import java.io.File;
import java.util.ArrayList;

public class PlaylistController {

    private ArrayList<Playlist> playlists;

    public PlaylistController() {
        this.playlists = new ArrayList<>();
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addPlaylist(Playlist playlist) {
        this.playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        this.playlists.remove(playlist);
    }

    public Playlist getPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(name)) {
                return playlist;
            }
        }
        return null;
    }

    public void loadPlaylists(String path) {
        File directory = new File(path);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    Playlist playlist = new Playlist(file.getName());
                    for (File songFile : file.listFiles()) {
                        if (songFile.getName().endsWith(".mp3")) {
                            playlist.addSong(songFile.getName());
                        }
                    }
                    this.addPlaylist(playlist);
                }
            }
        }
    }
}
