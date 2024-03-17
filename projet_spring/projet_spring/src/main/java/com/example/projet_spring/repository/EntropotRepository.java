package com.example.projet_spring.repository;

import com.example.projet_spring.entity.Entropot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntropotRepository extends JpaRepository<Entropot,Long> {
}
