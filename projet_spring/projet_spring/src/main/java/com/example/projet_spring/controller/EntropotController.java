package com.example.projet_spring.controller;

import com.example.projet_spring.entity.Entropot;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.repository.EntropotRepository;
import com.example.projet_spring.service.EntropotService;
import com.example.projet_spring.service.productservice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1")
@RequiredArgsConstructor
@CrossOrigin("*")
public class EntropotController {
    private final EntropotService entropotService;
    @PostMapping("/entropot")
    public Entropot postentropot(@RequestBody Entropot entropot){
        return entropotService.postenreopot(entropot);
    }

    @GetMapping("/entropots")
    private List<Entropot> getAllEntropot()
    {
        return entropotService.getAllEntropot();
    }
    @GetMapping("/entropot/{id}")
    private ResponseEntity<Entropot> getEntropotById(@PathVariable  Long id)
    {
        Entropot entropot=entropotService.getEntropotById(id);
        if(entropot==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entropot);
    }
    /*@GetMapping("/rayon/{id}")
    private ResponseEntity<Entropot> getRayonById(@PathVariable  Long id)
    {
        Entropot entropot=entropotService.getRayonById(id);
        if(entropot==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(entropot);
    }*/
    @PutMapping("/entropot/{id}")
    private ResponseEntity<Entropot> updateEntropot(@PathVariable  Long id,@RequestBody Entropot entropot)
    {
        Entropot existingEntropot=entropotService.getEntropotById(id);
        if(existingEntropot==null)
            return ResponseEntity.notFound().build();
        existingEntropot.setName(entropot.getName());
        existingEntropot.setCapaciteTotal(entropot.getCapaciteTotal());
        existingEntropot.setPrix(entropot.getPrix());
        existingEntropot.setNombreRayon(entropot.getNombreRayon());
        existingEntropot.setResponsable(entropot.getResponsable());
        existingEntropot.setProducts(entropot.getProducts());
        existingEntropot.setNombreRayon(entropot.getNombreRayon());
        existingEntropot.setNombreEtage(entropot.getNombreEtage());
        existingEntropot.setNombreCas(entropot.getNombreCas());
        Entropot updateEntrpot=entropotService.updateEntropot(existingEntropot);
        return ResponseEntity.ok(updateEntrpot);
    }
    @DeleteMapping ("/entropot/{id}")

    private ResponseEntity<?> deleteEntropot(@PathVariable  Long id){
        Entropot existingEntropot=entropotService.getEntropotById(id);
        if(existingEntropot==null)
            return ResponseEntity.notFound().build();
        entropotService.deleteEntropot(id);
        return  ResponseEntity.ok().build();

    }
    /*@DeleteMapping ("/rayon/{id}")

    private ResponseEntity<?> deleteRayon(@PathVariable  Long id){
        Entropot existingEntropot=entropotService.getRayonById(id);
        if(existingEntropot==null)
            return ResponseEntity.notFound().build();
        entropotService.deleteRayon(id);
        return  ResponseEntity.ok().build();

    }*/
}
