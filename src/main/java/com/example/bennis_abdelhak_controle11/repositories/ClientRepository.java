package com.example.bennis_abdelhak_controle11.repositories;


import com.example.bennis_abdelhak_controle11.entities.Client;
import com.example.bennis_abdelhak_controle11.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Recherche de client par nom
    List<Client> findByNom(String nom);
}

