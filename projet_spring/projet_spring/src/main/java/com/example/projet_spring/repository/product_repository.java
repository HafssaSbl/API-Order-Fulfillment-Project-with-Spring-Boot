package com.example.projet_spring.repository;

import com.example.projet_spring.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface product_repository extends JpaRepository<product,Long> {
}
