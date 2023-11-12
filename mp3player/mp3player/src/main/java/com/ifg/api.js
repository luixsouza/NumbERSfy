import axios from "axios";

export const getSongs = async () => {
  const response = await axios.get("/api/songs");
  const songs = await response.json();
  return songs;
};

export const addSong = async (song) => {
  await axios.post("/api/songs", { song });
};
