package com.example.javademo.javademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.javademo.javademo.entity.Location;
import com.example.javademo.javademo.service.LocationService;

@Controller
public class LocationController {

  @Autowired
  private LocationService locationService;

  // Getting all existing locations for main location page
  @GetMapping("/location")
  public String getAllLocations(Model model) {
    List<Location> locations = locationService.getAllLocations();
    model.addAttribute("locations", locations);
    return "location";
  }
  
  // Preparing data for adding new location page
  @GetMapping("/location/add")
  public String addLocation (Model model) {
    Location location = new Location();
    model.addAttribute("location", location);
    return "locationAdd";
  }

  // Saving new location
  @PostMapping("/location/save")
  public String saveLocation (@ModelAttribute Location location) {
    locationService.saveLocation(location);
    return "redirect:/location";
  }

  // Updating existing location
  @PostMapping("/location/update")
  public String updateLocation(@ModelAttribute Location location) {
    locationService.updateLocation(location);
    return "redirect:/location";
  }

  // Getting data for editing existing location
  @GetMapping("/location/edit/{id}")
  public String editLocation (@PathVariable int id, Model model) {
    Location location = locationService.getLocationById(id);
    model.addAttribute("location", location);
    return "locationEdit";
  }

  // Deleting existing location
  @PostMapping("/location/delete/{id}")
  public String deleteLocation(@PathVariable int id, Model model) {
    boolean isDeleted = locationService.deleteLocation(id);
    if (!isDeleted) {
      model.addAttribute("error", "There are still clients in this location. You cannot delete it until you change the clients' locations or delete them.");
      return getAllLocations(model);
    }
    return "redirect:/location";
  }
}