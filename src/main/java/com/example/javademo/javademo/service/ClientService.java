package com.example.javademo.javademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

  public void deleteClient(int id) {
    clientRepository.deleteById(id);
  }
}
