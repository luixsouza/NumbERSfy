package com.ifg.NumbERSfy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MusicController {

    @GetMapping("/getMusicInfo")
    public String getMusicInfo(Model model) {
    
        MusicInfo musicInfo = new MusicInfo(
            "/static/images/cranberries2.jpg",
            "Nome da Música",
            "Nome do Artista"
        );

    
        model.addAttribute("musicInfo", musicInfo);
        
        return "player";
    }
}

