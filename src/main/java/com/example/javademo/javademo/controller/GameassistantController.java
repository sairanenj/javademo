package com.example.javademo.javademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameassistantController {

  @GetMapping("/gameassistant")
  public String gaPage() {
    return "gameassistant";
  }
}
