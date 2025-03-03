package com.example.javademo.javademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javademo.javademo.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

}
