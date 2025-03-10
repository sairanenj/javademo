package com.example.javademo.javademo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "games")
public class Games {

  @Id
  @GeneratedValue
  @JdbcTypeCode(SqlTypes.VARCHAR)
  private UUID id;

  @Column(name = "gameName")
  private String gameName;

  @Column(name = "gameDetails")
  private String gameDetails;

  @Lob
  private byte[] data;

  // Many gameassistants for one game
  @OneToMany(mappedBy = "games", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Gameassistant> gameassistants;

  public Games() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public String getGameDetails() {
    return gameDetails;
  }

  public void setGameDetails(String gameDetails) {
    this.gameDetails = gameDetails;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public List<Gameassistant> getGameassistants() {
    return gameassistants;
  }

  public void setGameassistants(List<Gameassistant> gameassistants) {
    this.gameassistants = gameassistants;
  }
}