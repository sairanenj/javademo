package com.example.javademo.javademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javademo.javademo.entity.Homegames;
import com.example.javademo.javademo.repository.HomegamesRepository;

@Service
public class HomegamesService {

  @Autowired
  private HomegamesRepository homegamesRepository;

  public List<Homegames> getAllHomegames() {
    return homegamesRepository.findAll();
  }

  public Homegames getHomegameById(int id) {
    return homegamesRepository.findById(id).orElse(null);
  }

  public void saveHomegame(Homegames homegame) {
    homegamesRepository.save(homegame);
  }

  public void deleteHomegame(int id) {
    homegamesRepository.deleteById(id);
  }
}
