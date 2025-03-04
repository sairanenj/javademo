package com.example.javademo.javademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javademo.javademo.entity.Client;
import com.example.javademo.javademo.repository.ClientRepository;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  public Client getClientById(int id) {
    return clientRepository.findById(id).orElse(null);
  }

  public void updateClient(Client client) {
    clientRepository.save(client);
  }
}
