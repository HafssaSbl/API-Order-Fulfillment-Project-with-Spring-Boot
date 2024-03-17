package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="stockage")
public class Stockage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quantite_entrant;
    private String quantite_sortant;
    private String quantite_Actuel;
    private String fourniseur;
    @ManyToOne
    private product product;

}
