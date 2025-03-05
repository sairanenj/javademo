package com.example.javademo.javademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.javademo.javademo.entity.Client;
import com.example.javademo.javademo.entity.Location;
import com.example.javademo.javademo.service.ClientService;
import com.example.javademo.javademo.service.LocationService;

import org.springframework.ui.Model;

@Controller
public class ClientController {

  @Autowired
  private ClientService clientService;

  @Autowired
  private LocationService locationService;

  @GetMapping("/")
  public String homePage() {
    return "home";
  }

  @GetMapping("/client")
  public String getAllClients(Model model) {
    List<Client> clients = clientService.getAllClients();
    model.addAttribute("clients", clients);
    return "client";
  }

  @GetMapping("/client/add")
  public String addClient(Model model) {
    Client client = new Client();
    List<Location> locations = locationService.getAllLocations();
    model.addAttribute("client", client);
    model.addAttribute("locations", locations);
    return "clientAdd";
  }

  @PostMapping("/client/save")
  public String saveClient(@ModelAttribute Client client) {
    clientService.SaveClient(client);
    return "redirect:/client";
  }

  @GetMapping("/client/edit/{id}")
  public String editClient(@PathVariable int id, Model model) {
    Client client = clientService.getClientById(id);
    List<Location> locations = locationService.getAllLocations();
    model.addAttribute("client", client);
    model.addAttribute("locations", locations);
    return "clientEdit";
  }

  @PostMapping("/client/update")
  public String updateClient(@ModelAttribute Client client) {
    clientService.updateClient(client);
    return "redirect:/client";
  }

  @PostMapping("/client/delete/{id}")
  public String deleteClient(@PathVariable int id) {
    clientService.deleteClient(id);
    return "redirect:/client";
  }
}
