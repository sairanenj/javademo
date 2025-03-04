package com.example.javademo.javademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javademo.javademo.entity.Location;
import com.example.javademo.javademo.repository.LocationRepository;

@Service
public class LocationService {

  @Autowired
  private LocationRepository locationRepository;

  public List<Location> getAllLocations() {
    return locationRepository.findAll();
  }
}
