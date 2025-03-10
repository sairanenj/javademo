package com.example.javademo.javademo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.javademo.javademo.entity.Client;
import com.example.javademo.javademo.entity.Gameassistant;
import com.example.javademo.javademo.entity.Games;
import com.example.javademo.javademo.service.ClientService;
import com.example.javademo.javademo.service.GameassistantService;
import com.example.javademo.javademo.service.GamesService;

@Controller
public class GameassistantController {

  @Autowired
  private GameassistantService gameassistantService;

  @Autowired
  private ClientService clientService;

  @Autowired
  private GamesService gamesService;

  // Get all gameassistants for main page
  @GetMapping("/gameassistant")
  public String getAllGameAssistants(Model model) {
    List<Gameassistant> gameassistants = gameassistantService.getAllGameAssistants();
    model.addAttribute("gameassistants", gameassistants);
    return "gameassistant";
  }

  // Getting data for adding new gameassistant page
  @GetMapping("/gameassistant/add")
  public String addGameAssistant(Model model) {
    List<Client> clients = clientService.getAllClients();
    List<Games> games = gamesService.getAllGames();
    model.addAttribute("clients", clients);
    model.addAttribute("games", games);
    model.addAttribute("gameassistant", new Gameassistant());
    return "gameassistantAdd";
  }

  // Save new gameassistant
  @PostMapping("/gameassistant/save")
  public String saveGameAssistant(@RequestParam("clientId") int clientId,
      @RequestParam("gameId") UUID gameId,
      @RequestParam("inUse") boolean inUse,
      @RequestParam("thumbs") boolean thumbs,
      @RequestParam("notes") String notes) {
    Gameassistant gameassistant = new Gameassistant();
    gameassistant.setClient(clientService.getClientById(clientId));
    gameassistant.setGames(gamesService.getGameById(gameId));
    gameassistant.setInUse(inUse);
    gameassistant.setThumbs(thumbs);
    gameassistant.setNotes(notes);
    gameassistantService.saveGameAssistant(gameassistant);
    return "redirect:/gameassistant";
  }

  // Getting data for editing gameassistant page
  @GetMapping("/gameassistant/edit/{id}")
  public String editGameAssistant(@PathVariable int id, Model model) {
    Gameassistant gameassistant = gameassistantService.getGameAssistantById(id);
    model.addAttribute("gameassistant", gameassistant);
    return "gameassistantEdit";
  }

  // Update gameassistant
  @PostMapping("/gameassistant/update")
  public String updateGameAssistant(@RequestParam("id") int id,
      @RequestParam("inUse") boolean inUse,
      @RequestParam("thumbs") boolean thumbs,
      @RequestParam("notes") String notes) {
    Gameassistant gameassistant = gameassistantService.getGameAssistantById(id);
    gameassistant.setInUse(inUse);
    gameassistant.setThumbs(thumbs);
    gameassistant.setNotes(notes);
    gameassistantService.saveGameAssistant(gameassistant);
    return "redirect:/gameassistant";
  }

  // Delete gameassistant
  @PostMapping("/gameassistant/delete/{id}")
  public String deleteGameAssistant(@PathVariable int id) {
    gameassistantService.deleteGameAssistant(id);
    return "redirect:/gameassistant";
  }
}
