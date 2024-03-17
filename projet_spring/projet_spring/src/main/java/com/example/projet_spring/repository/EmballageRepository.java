package com.example.projet_spring.repository;

import com.example.projet_spring.entity.Commande;
import com.example.projet_spring.entity.Emballage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmballageRepository extends JpaRepository<Emballage,Long> {
}
