package com.example.bennis_abdelhak_controle11.services;

import com.example.bennis_abdelhak_controle11.entities.Client;
import com.example.bennis_abdelhak_controle11.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
