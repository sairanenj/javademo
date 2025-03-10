package com.example.javademo.javademo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  // Mapping for the login page
  @GetMapping("/login")
  public String login() {
    return "login";
  }
}