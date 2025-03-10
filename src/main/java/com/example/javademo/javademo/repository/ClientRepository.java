package com.example.javademo.javademo.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.javademo.javademo.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

  // Custom query to find clients by keyword with sorting
  @Query("SELECT c FROM Client c WHERE " +
      "c.firstName LIKE %?1% OR " +
      "c.lastName LIKE %?1% OR " +
      "c.phone LIKE %?1% OR " +
      "c.email LIKE %?1% OR " +
      "c.location.place LIKE %?1%")
  List<Client> findByKeyword(String keyword, Sort sort);
}
