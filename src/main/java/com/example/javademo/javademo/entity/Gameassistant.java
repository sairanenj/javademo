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

  @Column(name = "thumbs")
  private boolean thumbs;

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

  public Gameassistant(int id, boolean inUse, boolean thumbs, String notes, Client client,
      Games games) {
    this.id = id;
    this.inUse = inUse;
    this.thumbs = thumbs;
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

  public boolean isThumbs() {
    return thumbs;
  }

  public void setThumbs(boolean thumbs) {
    this.thumbs = thumbs;
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
