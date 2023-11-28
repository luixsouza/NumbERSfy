package com.ifg.NumbERSfy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Controller
public class HomeController {

    private List<Playlist> playlists;

    public HomeController() {
        playlists = new ArrayList<>();
        initializePlaylists();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("playlists", playlists);
        return "index";
    }

    @GetMapping("/player")
    public String player(@RequestParam String playlist, @RequestParam String song, Model model) {
        // Lógica para processar a solicitação e adicionar atributos ao modelo, se necessário
        model.addAttribute("playlist", playlist);
        model.addAttribute("song", song);

        // Retorne o nome da página Thymeleaf (sem extensão .html)
        return "player";
    }

    private void initializePlaylists() {
        Playlist playlist1 = new Playlist("Samba Esquema Novo");

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try {
            Resource[] resources = resolver.getResources("classpath:static/music/*.mp3");

            List<String> songNames = Arrays.stream(resources)
                    .map(this::getResourceFileName)
                    .collect(Collectors.toList());

            for (String songName : songNames) {
                playlist1.addSong(songName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        playlists.add(playlist1);
    }

    private String getResourceFileName(Resource resource) {
        return resource.getFilename();
    }
}
