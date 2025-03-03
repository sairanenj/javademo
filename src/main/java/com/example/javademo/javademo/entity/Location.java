package com.example.javademo.javademo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "place")
  private String place;

  @Column(name = "postOffice")
  private String postOffice;

  @Column(name = "postalCode")
  private String postalCode;

  @Column(name = "placeInfo")
  private String placeInfo;

  // Many clients for one location
  @OneToMany(mappedBy = "location")
  private List<Client> clients;

  public Location() {
  }

  public Location(int id, String place, String postOffice, String postalCode, String placeInfo, List<Client> clients) {
    this.id = id;
    this.place = place;
    this.postOffice = postOffice;
    this.postalCode = postalCode;
    this.placeInfo = placeInfo;
    this.clients = clients;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getPostOffice() {
    return postOffice;
  }

  public void setPostOffice(String postOffice) {
    this.postOffice = postOffice;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getPlaceInfo() {
    return placeInfo;
  }

  public void setPlaceInfo(String placeInfo) {
    this.placeInfo = placeInfo;
  }

  public List<Client> getClients() {
    return clients;
  }

  public void setClients(List<Client> clients) {
    this.clients = clients;
  }
}
