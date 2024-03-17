package com.example.projet_spring.controller;
//entity : gerer par des jpa
//model : se sont des vues
import com.example.projet_spring.entity.Emballage;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.service.EmballageServise;
import com.example.projet_spring.service.productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api3")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EmballageController {
    private final EmballageServise emballageServise;
    @PostMapping("/emballage")
    public Emballage postEmballage(@RequestBody Emballage emballage){
        return emballageServise.postEmballage(emballage);
    }

    @GetMapping("/emballages")
    private List<Emballage> getAllEmballage()
    {
        return emballageServise.getAllEmballage();
    }
    @GetMapping("/emballage/{id}")
    private ResponseEntity<Emballage> getEmballagesById(@PathVariable Long id)
    {
        Emballage emballage=emballageServise.getEmballageById(id);
        if(emballage==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(emballage);
    }
    @PutMapping("/emballage/{id}")
    private ResponseEntity<Emballage> updateEmballage(@PathVariable  Long id,@RequestBody Emballage emballage)
    {
        Emballage existingEmballage=emballageServise.getEmballageById(id);
        if(existingEmballage==null)
            return ResponseEntity.notFound().build();
        existingEmballage.setType_emballage(emballage.getType_emballage());
        existingEmballage.setCout(emballage.getCout());
        existingEmballage.setTaille(emballage.getTaille());
        existingEmballage.setPoint(emballage.getPoint());
        existingEmballage.setEffecacite(emballage.getEffecacite());
        Emballage updateEmballage=emballageServise.updateEmballage(existingEmballage);
        return ResponseEntity.ok(updateEmballage);
    }
    @DeleteMapping ("/emballage/{id}")

    private ResponseEntity<?> deleteEmballage(@PathVariable  Long id){
        Emballage existingEmballage=emballageServise.getEmballageById(id);
        if(existingEmballage==null)
            return ResponseEntity.notFound().build();
        emballageServise.deleteEmballage(id);
        return  ResponseEntity.ok().build();

    }
}
