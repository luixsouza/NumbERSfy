package com.ifg;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

public class MP3Player {

    private AudioInputStream audioInputStream;
    private Clip clip;
    private ArrayList<String> playlist;
    private int currentSongIndex;
    private Image playImage;
    private Image pauseImage;

    public MP3Player() {
        playlist = new ArrayList<>();
        currentSongIndex = -1;
        playImage = new ImageIcon("C:\\Users\\Luis Eduardo\\Desktop\\mp3player\\mp3player\\src\\main\\resources\\play.png").getImage();
        pauseImage = new ImageIcon("C:\\Users\\Luis Eduardo\\Desktop\\mp3player\\mp3player\\src\\main\\resources\\pause.png").getImage();
    }

    public void addSong(String filename) {
        playlist.add(filename);
    }

    public void play() {
        if (currentSongIndex == -1) {
            return;
        }

        try {
            if (clip != null && clip.isOpen()) {
                clip.close();
            }

            audioInputStream = AudioSystem.getAudioInputStream(new File(playlist.get(currentSongIndex)));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            clip.start();
            playImage = pauseImage;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        if (clip != null && clip.isOpen()) {
            clip.stop();
            playImage = playImage;
        }
    }

    public void stop() {
        if (clip != null && clip.isOpen()) {
            clip.close();
        }
    }

    public void playNextSong() {
        if (currentSongIndex < playlist.size() - 1) {
            currentSongIndex++;
            play();
        }
    }

    public void playPreviousSong() {
        if (currentSongIndex > 0) {
            currentSongIndex--;
            play();
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isOpen() && clip.isRunning();
    }

    public Image getPlayImage() {
        return playImage;
    }

    public static void main(String[] args) {
        PlaylistController controller = new PlaylistController();
        controller.loadPlaylists("C:\\Users\\Luis Eduardo\\Music");

        for (Playlist playlist : controller.getPlaylists()) {
            System.out.println(playlist.getName());
        }
    }
}
