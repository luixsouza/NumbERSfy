import api from "./api";

const audioPlayer = document.querySelector("#audioPlayer");
const playPauseButton = document.querySelector("#playPauseButton");
const rewindButton = document.querySelector("#rewindButton");
const forwardButton = document.querySelector("#forwardButton");
const volumeSlider = document.querySelector("#volumeSlider");

playPauseButton.addEventListener("click", () => {
  if (audioPlayer.paused) {
    audioPlayer.play();
  } else {
    audioPlayer.pause();
  }
});

rewindButton.addEventListener("click", () => {
  audioPlayer.currentTime -= 10;
});

forwardButton.addEventListener("click", () => {
  audioPlayer.currentTime += 10;
});

volumeSlider.addEventListener("input", () => {
  audioPlayer.volume = volumeSlider.value / 100;
});
