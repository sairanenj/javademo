package com.example.javademo.javademo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "userName")
  private String userName;

  @Column(name = "role")
  private String role;

  @Column(name = "task")
  private String task;

  public User() {
  }
  
  public User(int id, String userName, String role, String task) {
    this.id = id;
    this.userName = userName;
    this.role = role;
    this.task = task;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getTask() {
    return task;
  }

  public void setTask(String task) {
    this.task = task;
  }
}
