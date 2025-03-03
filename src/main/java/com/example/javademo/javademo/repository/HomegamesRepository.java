package com.example.javademo.javademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javademo.javademo.entity.Homegames;

@Repository
public interface HomegamesRepository extends JpaRepository<Homegames, Integer> {

}
