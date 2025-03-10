package com.example.javademo.javademo.service;

import com.example.javademo.javademo.entity.Games;
import com.example.javademo.javademo.repository.GamesRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GamesService {

  @Autowired
  private GamesRepository gamesRepository;

  public List<Games> getAllGames() {
    return gamesRepository.findAll();
  }

  public void saveGame(Games game) {
    gamesRepository.save(game);
  }

  public Games getGameById(UUID id) {
    return gamesRepository.findById(id).orElse(null);
  }

  @Transactional
  public void deleteGame(UUID id) {
    gamesRepository.deleteById(id);
  }
}