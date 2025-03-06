package com.example.javademo.javademo.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.javademo.javademo.entity.Games;
import com.example.javademo.javademo.service.GamesService;

@Controller
public class GamesController {

  @Autowired
  private GamesService gamesService;

  @GetMapping("/games")
  public String getAllGames(Model model) {
    List<Games> games = gamesService.getAllGames();
    model.addAttribute("games", games);
    return "games";
  }

  @GetMapping("/games/add")
  public String addGame(Model model) {
    model.addAttribute("game", new Games());
    return "gameAdd";
  }

  @PostMapping("/games/save")
    public String saveGame(@RequestParam("gameName") String gameName,
                           @RequestParam("gameDetails") String gameDetails,
                           @RequestParam("data") MultipartFile file,
                           RedirectAttributes redirectAttributes) throws IOException {
        if (!file.getContentType().startsWith("image/")) {
            redirectAttributes.addFlashAttribute("error", "Only image files are allowed");
            return "redirect:/games";
        }
        Games game = new Games();
        game.setGameName(gameName);
        game.setGameDetails(gameDetails);
        game.setData(file.getBytes());
        gamesService.saveGame(game);
        return "redirect:/games";
    }

  @GetMapping("/games/image/{id}")
  public ResponseEntity<byte[]> getImage(@PathVariable UUID id) {
    Games game = gamesService.getGameById(id);
    if (game != null && game.getData() != null) {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(org.springframework.http.MediaType.IMAGE_JPEG);
      return new ResponseEntity<>(game.getData(), headers, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping("/games/delete/{id}")
  public String deleteGame(@PathVariable UUID id, RedirectAttributes redirectAttributes) {
    gamesService.deleteGame(id);
    redirectAttributes.addFlashAttribute("message", "Game deleted successfully!");
    return "redirect:/games";
  }
}
