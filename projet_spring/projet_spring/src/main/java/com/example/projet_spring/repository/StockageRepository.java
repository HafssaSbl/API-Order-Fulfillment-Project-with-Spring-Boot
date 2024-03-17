package com.example.projet_spring.repository;

import com.example.projet_spring.entity.Commande;
import com.example.projet_spring.entity.Stockage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockageRepository extends JpaRepository<Stockage,Long> {
}
