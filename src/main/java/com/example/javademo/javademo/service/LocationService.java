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
  
  public Location getLocationById(int id) {
    return locationRepository.findById(id).orElse(null);
  }

  public void saveLocation(Location location) {
    locationRepository.save(location);
  }

  public void updateLocation(Location location) {
    locationRepository.save(location);
  }

  // Delete by location ID. Checking if the location exists and has no associated clients. Returns false if cannot be deleted.
  public boolean deleteLocation(int id) {
    Location location = locationRepository.findById(id).orElse(null);
    if (location != null && (location.getClients() == null || location.getClients().isEmpty())) {
      locationRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
