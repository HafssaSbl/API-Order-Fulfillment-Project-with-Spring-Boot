package com.example.projet_spring.service;

import com.example.projet_spring.entity.Stockage;
import com.example.projet_spring.entity.product;
import com.example.projet_spring.repository.StockageRepository;
import com.example.projet_spring.repository.product_repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockageServise {
    private final StockageRepository stockageRepository;
    public Stockage postStockage(Stockage stockage)
    {
        return stockageRepository.save(stockage);
    }
    public List<Stockage> getAllStockage()
    {
        return stockageRepository.findAll();  }
    public Stockage getStockageById(Long id ){
        return  stockageRepository.findById(id).orElse(null);
    }
    public Stockage updateStockage(Stockage stockage ){
        return  stockageRepository.save(stockage);
    }
    public void deleteStockage(Long id ){
        stockageRepository.deleteById(id);
    }

}
