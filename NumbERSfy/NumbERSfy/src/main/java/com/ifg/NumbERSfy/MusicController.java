package com.ifg.NumbERSfy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {

    @GetMapping("/getMusicInfo")
    public String getMusicInfo(Model model) {
        // Aqui você deve fornecer as informações reais da música
        MusicInfo musicInfo = new MusicInfo(
            "/static/caminho-da-imagem-do-album.jpg",
            "Nome da Música",
            "Nome do Artista"
        );

        // Adiciona as informações ao modelo
        model.addAttribute("musicInfo", musicInfo);

        // Retorna a página Thymeleaf (HTML) que exibirá as informações
        return "musicInfo";
    }
}

