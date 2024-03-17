package com.example.projet_spring.controller;

import com.example.projet_spring.entity.Stockage;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.service.StockageServise;
import com.example.projet_spring.service.productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StockageController {
    private final StockageServise stockageServise;
    @PostMapping("/stockage")
    public Stockage postStockage(@RequestBody Stockage stockage){
        return stockageServise.postStockage(stockage);
    }

    @GetMapping("/stockages")
    private List<Stockage> getAllStockage()
    {
        return stockageServise.getAllStockage();
    }
    @GetMapping("/Stockage/{id}")
    private ResponseEntity<Stockage> getStockageById(@PathVariable  Long id)
    {
        Stockage stockage=stockageServise.getStockageById(id);
        if(stockage==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(stockage);
    }
    @PutMapping("/stockage/{id}")
    private ResponseEntity<Stockage> updateStockage(@PathVariable  Long id,@RequestBody Stockage stockage)
    {
        Stockage existingStockage=stockageServise.getStockageById(id);
        if(stockage==null)
            return ResponseEntity.notFound().build();
        existingStockage.setFourniseur(stockage.getFourniseur());
        existingStockage.setQuantite_entrant(stockage.getQuantite_entrant());
        existingStockage.setQuantite_sortant(stockage.getQuantite_sortant());
        existingStockage.setQuantite_Actuel(stockage.getQuantite_Actuel());


        Stockage updateStockage=stockageServise.updateStockage(existingStockage);
        return ResponseEntity.ok(updateStockage);
    }
    @DeleteMapping ("/stockage/{id}")

    private ResponseEntity<?> deleteStockage(@PathVariable  Long id){
        Stockage existingStockage=stockageServise.getStockageById(id);
        if(existingStockage==null)
            return ResponseEntity.notFound().build();
        stockageServise.deleteStockage(id);
        return  ResponseEntity.ok().build();

    }
}
