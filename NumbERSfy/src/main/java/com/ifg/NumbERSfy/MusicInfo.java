package com.ifg.NumbERSfy;

public class MusicInfo {
    private String albumCoverUrl;
    private String songName;
    private String artistName;

    public MusicInfo(String albumCoverUrl, String songName, String artistName) {
        this.albumCoverUrl = albumCoverUrl;
        this.songName = songName;
        this.artistName = artistName;
    }

    public String getAlbumCoverUrl() {
        return albumCoverUrl;
    }

    public void setAlbumCoverUrl(String albumCoverUrl) {
        this.albumCoverUrl = albumCoverUrl;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}

