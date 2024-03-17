package com.example.projet_spring.service;

import com.example.projet_spring.entity.Commande;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.repository.CommandeRepository;
import com.example.projet_spring.repository.product_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommandeService {
    private final CommandeRepository commandeRepository;
    public Commande postCommande(Commande commande)
    {
        return commandeRepository.save(commande);  }
    public List<Commande> getAllCommande()
    {
        return commandeRepository.findAll();  }
    public Commande getCommandeById(Long id ){
        return  commandeRepository.findById(id).orElse(null);
    }
    public Commande updateCommande(Commande commande ){
        return  commandeRepository.save(commande);
    }
    public void deleteCommande(Long id ){
        commandeRepository.deleteById(id);
    }

}
