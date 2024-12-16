package com.example.bennis_abdelhak_controle11.repositories;

import com.example.bennis_abdelhak_controle11.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    // Recherche des commandes par ID de client
    List<Commande> findByClientId(Long clientId);
}

