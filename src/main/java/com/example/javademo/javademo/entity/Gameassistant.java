package com.example.javademo.javademo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gameassistant")
public class Gameassistant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "inUse")
  private boolean inUse;

  @Column(name = "thumbsUp")
  private boolean thumbsUp;

  @Column(name = "thumbsDown")
  private boolean thumbsDown;

  @Column(name = "notes")
  private String notes;

  // Many gameassistants for one client
  @ManyToOne
  private Client client;

  // Many gameassistants for one game
  @ManyToOne
  private Games games;

  public Gameassistant() {
  }

  public Gameassistant(int id, boolean inUse, boolean thumbsUp, boolean thumbsDown, String notes, Client client,
      Games games) {
    this.id = id;
    this.inUse = inUse;
    this.thumbsUp = thumbsUp;
    this.thumbsDown = thumbsDown;
    this.notes = notes;
    this.client = client;
    this.games = games;
  }

  public boolean isInUse() {
    return inUse;
  }

  public void setInUse(boolean inUse) {
    this.inUse = inUse;
  }

  public boolean isThumbsUp() {
    return thumbsUp;
  }

  public void setThumbsUp(boolean thumbsUp) {
    this.thumbsUp = thumbsUp;
  }

  public boolean isThumbsDown() {
    return thumbsDown;
  }

  public void setThumbsDown(boolean thumbsDown) {
    this.thumbsDown = thumbsDown;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Games getGames() {
    return games;
  }

  public void setGames(Games games) {
    this.games = games;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
