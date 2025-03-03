package com.example.javademo.javademo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "homegames")
public class Homegames {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(name = "gamesHome")
  private String gamesHome;

  @Column(name = "gamesDaycare")
  private String gamesDaycare;

  @Column(name = "homegamesInfo")
  private String homegamesInfo;

  // Many homegames for same client
  @ManyToOne
  private Client client;

  public Homegames() {
  }
  
  public Homegames(int id, String gamesHome, String gamesDaycare, String homegamesInfo, Client client) {
    this.id = id;
    this.gamesHome = gamesHome;
    this.gamesDaycare = gamesDaycare;
    this.homegamesInfo = homegamesInfo;
    this.client = client;
  }

  public String getGamesHome() {
    return gamesHome;
  }

  public void setGamesHome(String gamesHome) {
    this.gamesHome = gamesHome;
  }

  public String getGamesDaycare() {
    return gamesDaycare;
  }

  public void setGamesDaycare(String gamesDaycare) {
    this.gamesDaycare = gamesDaycare;
  }

  public String getHomegamesInfo() {
    return homegamesInfo;
  }

  public void setHomegamesInfo(String homegamesInfo) {
    this.homegamesInfo = homegamesInfo;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
