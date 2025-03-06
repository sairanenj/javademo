package com.example.javademo.javademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javademo.javademo.entity.Gameassistant;
import com.example.javademo.javademo.repository.GameassistantRepository;

@Service
public class GameassistantService {

  @Autowired
  private GameassistantRepository gameassistantRepository;

  public List<Gameassistant> getAllGameAssistants() {
    return gameassistantRepository.findAll();
  }

  public Gameassistant getGameAssistantById(int id) {
    return gameassistantRepository.findById(id).orElse(null);
  }

  public void saveGameAssistant(Gameassistant gameassistant) {
    gameassistantRepository.save(gameassistant);
  }

  public void deleteGameAssistant(int id) {
    gameassistantRepository.deleteById(id);
  }
}
