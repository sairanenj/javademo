package com.example.javademo.javademo.service;

import com.example.javademo.javademo.entity.User;
import com.example.javademo.javademo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }

  public void deleteUser(int id) {
    userRepository.deleteById(id);
  }
}