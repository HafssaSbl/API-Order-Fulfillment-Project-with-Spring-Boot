package com.example.projet_spring.service;

import com.example.projet_spring.entity.Emballage;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.repository.EmballageRepository;
import com.example.projet_spring.repository.product_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmballageServise {
    private final EmballageRepository emballageRepository;
    public Emballage postEmballage(Emballage emballage)
    {
        return emballageRepository.save(emballage);  }
    public List<Emballage> getAllEmballage()
    {
        return emballageRepository.findAll();  }
    public Emballage getEmballageById(Long id ){
        return  emballageRepository.findById(id).orElse(null);
    }
    public Emballage updateEmballage(Emballage emballage ){
        return  emballageRepository.save(emballage);
    }
    public void deleteEmballage(Long id ){
        emballageRepository.deleteById(id);
    }

}
