package com.example.javademo.javademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomegamesController {
  
  @GetMapping("/homegames")
  public String hgPage() {
    return "homegames";
  }
}
