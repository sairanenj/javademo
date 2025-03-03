package com.example.javademo.javademo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javademo.javademo.entity.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games, UUID> {

}
