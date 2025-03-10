package com.example.javademo.javademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  // Mapping to home page
  @GetMapping("/")
  public String homePage() {
    return "home";
  }

  // Get all clients (used for foreign key ones)
  @GetMapping("/client")
  public String getAllClients(Model model) {
    List<Client> clients = clientService.getAllClients();
    model.addAttribute("clients", clients);
    return "client";
  }

  // Get all clients with sorting and keyword search
  @GetMapping("/clients")
  public String getAllClientsSort(Model model,
                              @RequestParam(value = "sortField", required = false, defaultValue = "id") String sortField,
                              @RequestParam(value = "sortDir", required = false, defaultValue = "asc") String sortDir,
                              @RequestParam(value = "keyword", required = false) String keyword) {
    List<Client> clients = clientService.getAllClientsSort(sortField, sortDir, keyword);
    model.addAttribute("clients", clients);
    model.addAttribute("sortField", sortField);
    model.addAttribute("sortDir", sortDir);
    model.addAttribute("keyword", keyword);
    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
    return "clients";
  }

  // Getting data for adding new client page
  @GetMapping("/client/add")
  public String addClient(Model model) {
    Client client = new Client();
    List<Location> locations = locationService.getAllLocations();
    model.addAttribute("client", client);
    model.addAttribute("locations", locations);
    return "clientAdd";
  }

  // Save new client
  @PostMapping("/client/save")
  public String saveClient(@ModelAttribute Client client) {
    clientService.SaveClient(client);
    return "redirect:/clients";
  }

  // Getting data for editing an existing client
  @GetMapping("/client/edit/{id}")
  public String editClient(@PathVariable int id, Model model) {
    Client client = clientService.getClientById(id);
    List<Location> locations = locationService.getAllLocations();
    model.addAttribute("client", client);
    model.addAttribute("locations", locations);
    return "clientEdit";
  }

  // Update an existing client
  @PostMapping("/client/update")
  public String updateClient(@ModelAttribute Client client) {
    clientService.updateClient(client);
    return "redirect:/clients";
  }

  // Delete existing client
  @PostMapping("/client/delete/{id}")
  public String deleteClient(@PathVariable int id) {
    clientService.deleteClient(id);
    return "redirect:/clients";
  }
}
