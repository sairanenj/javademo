package com.example.javademo.javademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.javademo.javademo.entity.Location;
import com.example.javademo.javademo.service.LocationService;

@Controller
public class LocationController {

  @Autowired
  private LocationService locationService;

  @GetMapping("/location")
  public String getAllLocations(Model model) {
    List<Location> locations = locationService.getAllLocations();
    model.addAttribute("locations", locations);
    return "location";
  }
}