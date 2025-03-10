package com.example.javademo.javademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.javademo.javademo.entity.Client;
import com.example.javademo.javademo.repository.ClientRepository;

import jakarta.transaction.Transactional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  // Getting all clients (used for foreign key ones)
  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  // Get all clients with sorting and keyword search (main client page usage)
  public List<Client> getAllClientsSort(String sortField, String sortDir, String keyword) {
    Sort sort = Sort.by(Sort.Direction.fromString(sortDir), sortField);
    if (keyword != null && !keyword.isEmpty()) {
      return clientRepository.findByKeyword(keyword, sort);
    } else {
      return clientRepository.findAll(sort);
    }
  }

  public void SaveClient(Client client) {
    clientRepository.save(client);
  }
  
  public Client getClientById(int id) {
    return clientRepository.findById(id).orElse(null);
  }

  public void updateClient(Client client) {
    clientRepository.save(client);
  }

  @Transactional
  public void deleteClient(int id) {
    clientRepository.deleteById(id);
  }
}
