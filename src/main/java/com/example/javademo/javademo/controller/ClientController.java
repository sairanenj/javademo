package com.example.javademo.javademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClientController {

  @GetMapping("/")
  public String homePage() {
    return "home";
  }

  @GetMapping("/client")
  public String clientPage() {
    return "client";
  }
}
