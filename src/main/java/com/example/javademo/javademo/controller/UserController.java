package com.example.javademo.javademo.controller;

import com.example.javademo.javademo.entity.User;
import com.example.javademo.javademo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public String getAllUsers(Model model) {
    List<User> users = userService.getAllUsers();
    model.addAttribute("users", users);
    return "user";
  }

  @GetMapping("/user/add")
  public String addUser(Model model) {
    model.addAttribute("user", new User());
    return "userAdd";
  }

  @PostMapping("/user/save")
  public String saveUser(@RequestParam("userName") String userName, @RequestParam("role") String role, @RequestParam("task") String task) {
    User user = new User();
    user.setUserName(userName);
    user.setRole(role);
    user.setTask(task);
    userService.saveUser(user);
    return "redirect:/user";
  }

  @PostMapping("/user/delete/{id}")
  public String deleteUser(@PathVariable int id) {
    userService.deleteUser(id);
    return "redirect:/user";
  }
}