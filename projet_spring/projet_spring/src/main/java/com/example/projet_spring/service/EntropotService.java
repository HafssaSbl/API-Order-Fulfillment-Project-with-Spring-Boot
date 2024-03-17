package com.example.projet_spring.service;

import com.example.projet_spring.entity.Entropot;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.repository.EntropotRepository;
import com.example.projet_spring.repository.product_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EntropotService {
    private final EntropotRepository entropotRepository;
    public Entropot postenreopot(Entropot entropot)
    {
        return entropotRepository.save(entropot);  }
    public List<Entropot> getAllEntropot()
    {
        return entropotRepository.findAll();  }
    public Entropot getEntropotById(Long id ){
        return  entropotRepository.findById(id).orElse(null);
    }
    /*public Entropot getRayonById(Long id ){
        return  entropotRepository.findById(id).orElse(null);
    }*/

    public Entropot updateEntropot(Entropot entropot ){
        return  entropotRepository.save(entropot);
    }
    public void deleteEntropot(Long id ){
        entropotRepository.deleteById(id);
    }
   /* public void deleteRayon(Long id ){
        entropotRepository.deleteById(id);
    }*/


}
