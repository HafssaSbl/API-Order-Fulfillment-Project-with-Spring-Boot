package com.example.projet_spring.controller;

import com.example.projet_spring.entity.Commande;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.service.CommandeService;
import com.example.projet_spring.service.productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api4")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CommandeController {

    private final CommandeService commandeService;
    @PostMapping("/commande")
    public Commande postCommande(@RequestBody Commande commande){
        return commandeService.postCommande(commande);
    }

    @GetMapping("/commandes")
    private List<Commande> getAllCommande()
    {
        return commandeService.getAllCommande();
    }
    @GetMapping("/commande/{id}")
    private ResponseEntity<Commande> getCommandeById(@PathVariable  Long id)
    {
        Commande commande=commandeService.getCommandeById(id);
        if(commande==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(commande);
    }
    @PutMapping("/commande/{id}")
    private ResponseEntity<Commande> updateCommande(@PathVariable  Long id,@RequestBody Commande commande)
    {
        Commande existingCommande=commandeService.getCommandeById(id);
        if(existingCommande==null)
            return ResponseEntity.notFound().build();
        existingCommande.setAdress(commande.getAdress());
        existingCommande.setNameClient(commande.getNameClient());
        existingCommande.setNum_tel(commande.getNum_tel());
        existingCommande.setQuantit_produit(commande.getQuantit_produit());
        existingCommande.setProducts(commande.getProducts());

        Commande updateCommande=commandeService.updateCommande(existingCommande);
        return ResponseEntity.ok(updateCommande);
    }
    @DeleteMapping ("/commande/{id}")

    private ResponseEntity<?> deleteCommande(@PathVariable  Long id){
        Commande existingCommande=commandeService.getCommandeById(id);
        if(existingCommande==null)
            return ResponseEntity.notFound().build();
        commandeService.deleteCommande(id);
        return  ResponseEntity.ok().build();

    }
}
