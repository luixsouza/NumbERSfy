import api from "./api";

class MP3Player {
  constructor(audioPlayer) {
    this.audioPlayer = audioPlayer;
    this.playlist = [];
    this.currentSongIndex = -1;
    this.volume = 1;
  }

  async getSongs() {
    const response = await api.get("/api/songs");
    const songs = await response.json();
    this.playlist = songs;
    return this.playlist;
  }

  async addSong(song) {
    await api.post("/api/songs", { song });
  }

  play() {
    if (this.currentSongIndex === -1) {
      return;
    }

    this.audioPlayer.src = this.playlist[this.currentSongIndex];
    this.audioPlayer.play();
  }

  pause() {
    this.audioPlayer.pause();
  }

  stop() {
    this.audioPlayer.stop();
  }

  next() {
    if (this.currentSongIndex < this.playlist.length - 1) {
      this.currentSongIndex++;
      this.play();
    }
  }

  previous() {
    if (this.currentSongIndex > 0) {
      this.currentSongIndex--;
      this.play();
    }
  }

  updateVolume(volume) {
    this.volume = volume;
    this.audioPlayer.volume = volume;
  }

  addSong(song) {
    this.playlist.push(song);
  }

  getPlaylist() {
    return this.playlist;
  }

  getCurrentSongIndex() {
    return this.currentSongIndex;
  }

  isPlaying() {
    return this.audioPlayer.isPlaying;
  }
}
