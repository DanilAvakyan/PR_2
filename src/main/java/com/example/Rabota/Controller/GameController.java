package com.example.Rabota.Controller;

import com.example.Rabota.Models.Game;
import com.example.Rabota.repo.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GamesRepository gamesRepository;

    @GetMapping("/")
    public String GetGame(Model model)
    {
        Iterable<Game> games = gamesRepository.findAll();
        model.addAttribute("Games",games);
        return "MainGame";
    }
    @GetMapping("/Add/Game")
    public String GetAddGame(Model model)
    {
        return "Add-Game";
    }
    @PostMapping("/Add/Game")
    public String blogPostAdd(@RequestParam(value="name") String name,
                              @RequestParam(value ="price" ) float price,
                              @RequestParam(value = "developer") String developer,
                              @RequestParam(value ="genre" ) String genre,
                              @RequestParam(value = "publisher") String publisher,
                              @RequestParam(value = "specifications") String specifications,
                              Model model)
    {
        Game game = new Game(name, price, developer, genre, publisher, specifications);
        gamesRepository.save(game);
        return "redirect:/";
    }

    @GetMapping( path = "/Search/Game")
    public String blogFilter(Model model)
    {
        return "Search-Game";
    }

    @PostMapping("/Search/Game-result")
    public String blogResult(@RequestParam String name, Model model)
    {
        List<Game> games = gamesRepository.findByName(name);
        model.addAttribute("result", games);
        return "Search-Game";
    }
    @PostMapping("/Search/Game")
    public String simpleSearch(@RequestParam float price, Model model)
    {
        List<Game> games = gamesRepository.findByPrice(price);
        model.addAttribute("result", games);
        return "Search-Game";
    }

}
