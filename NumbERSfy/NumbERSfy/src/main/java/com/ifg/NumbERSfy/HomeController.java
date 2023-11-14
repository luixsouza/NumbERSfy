package com.ifg.NumbERSfy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Playlist> playlists;

    public HomeController() {
        playlists = new ArrayList<>();
        initializePlaylists();  // Método para criar playlists de exemplo
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("playlists", playlists);
        return "NumbERSfy";
    }

    private void initializePlaylists() {
        Playlist playlist1 = new Playlist("Playlist 1");
        playlist1.addSong("sua-musica1.mp3");
        playlist1.addSong("sua-musica2.mp3");

        Playlist playlist2 = new Playlist("Playlist 2");
        playlist2.addSong("outra-musica1.mp3");
        playlist2.addSong("outra-musica2.mp3");

        playlists.add(playlist1);
        playlists.add(playlist2);
    }
}
