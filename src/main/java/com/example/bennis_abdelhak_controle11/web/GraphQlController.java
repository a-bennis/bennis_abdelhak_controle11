package com.example.bennis_abdelhak_controle11.web;

import com.example.bennis_abdelhak_controle11.entities.Client;
import com.example.bennis_abdelhak_controle11.entities.Commande;
import com.example.bennis_abdelhak_controle11.services.ClientService;
import com.example.bennis_abdelhak_controle11.services.CommandeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class GraphQlController {
    private final CommandeService commandeService;
    private final ClientService clientService;

    public GraphQlController(CommandeService commandeService, ClientService clientService) {
        this.commandeService = commandeService;
        this.clientService = clientService;
    }

    @QueryMapping
    public List<Commande> commandes() {
        return commandeService.getAllCommandes();
    }

    @QueryMapping
    public Commande commandeById(@Argument Long id) {
        return commandeService.getCommandeById(id);
    }

    @QueryMapping
    public List<Client> clients() {
        return clientService.getAllClients();
    }

    @MutationMapping
    public Commande addCommande(@Argument String dateCommande, @Argument Double montantTotal, @Argument Long clientId) {
        Commande commande = new Commande();
        commande.setDateCommande(new Date(dateCommande));
        commande.setMontantTotal(montantTotal);
        Client client = clientService.getAllClients().stream()
                .filter(c -> c.getId().equals(clientId)).findFirst().orElse(null);
        commande.setClient(client);
        return commandeService.saveCommande(commande);
    }

    @MutationMapping
    public Commande updateCommande(@Argument Long id, @Argument String dateCommande, @Argument Double montantTotal) {
        Commande existingCommande = commandeService.getCommandeById(id);
        if (existingCommande != null) {
            if (dateCommande != null) existingCommande.setDateCommande(new Date(dateCommande));
            if (montantTotal != null) existingCommande.setMontantTotal(montantTotal);
            return commandeService.saveCommande(existingCommande);
        }
        return null;
    }

    @MutationMapping
    public Boolean deleteCommande(@Argument Long id) {
        commandeService.deleteCommande(id);
        return true;
    }
}
