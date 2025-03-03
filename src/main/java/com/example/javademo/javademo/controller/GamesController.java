package com.example.javademo.javademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GamesController {

  @GetMapping("/games")
  public String gamesPage() {
    return "games";
  }
}
