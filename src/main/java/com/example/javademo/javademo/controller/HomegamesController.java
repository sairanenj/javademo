package com.example.javademo.javademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.javademo.javademo.entity.Client;
import com.example.javademo.javademo.entity.Homegames;
import com.example.javademo.javademo.service.ClientService;
import com.example.javademo.javademo.service.HomegamesService;

@Controller
public class HomegamesController {

  @Autowired
  private HomegamesService homegamesService;

  @Autowired
  private ClientService clientService;

  @GetMapping("/homegames")
  public String getAllHomegames(Model model) {
    List<Homegames> homegames = homegamesService.getAllHomegames();
    model.addAttribute("homegames", homegames);
    return "homegames";
  }

  @GetMapping("/homegames/add")
  public String addHomegame(Model model) {
    List<Client> clients = clientService.getAllClients();
    model.addAttribute("clients", clients);
    model.addAttribute("homegame", new Homegames());
    return "homegamesAdd";
  }

  @PostMapping("/homegames/save")
  public String saveHomegame(@RequestParam("clientId") int clientId, @RequestParam("gamesHome") String gamesHome, @RequestParam("gamesDaycare") String gamesDaycare, @RequestParam("homegamesInfo") String homegamesInfo) {
    Homegames homegame = new Homegames();
    homegame.setClient(clientService.getClientById(clientId));
    homegame.setGamesHome(gamesHome);
    homegame.setGamesDaycare(gamesDaycare);
    homegame.setHomegamesInfo(homegamesInfo);
    homegamesService.saveHomegame(homegame);
    return "redirect:/homegames";
  }

  @GetMapping("/homegames/edit/{id}")
  public String editHomegame(@PathVariable int id, Model model) {
    Homegames homegame = homegamesService.getHomegameById(id);
    model.addAttribute("homegame", homegame);
    return "homegamesEdit";
  }

  @PostMapping("/homegames/update")
  public String updateHomegame(@RequestParam("id") int id, @RequestParam("gamesHome") String gamesHome, @RequestParam("gamesDaycare") String gamesDaycare, @RequestParam("homegamesInfo") String homegamesInfo) {
    Homegames homegame = homegamesService.getHomegameById(id);
    homegame.setGamesHome(gamesHome);
    homegame.setGamesDaycare(gamesDaycare);
    homegame.setHomegamesInfo(homegamesInfo);
    homegamesService.saveHomegame(homegame);
    return "redirect:/homegames";
  }

  @PostMapping("/homegames/delete/{id}")
  public String deleteHomegame(@PathVariable int id) {
    homegamesService.deleteHomegame(id);
    return "redirect:/homegames";
  }
}
