package com.example.projet_spring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float prix;
    private int quantite_en_stock;
    private String fournisseur;
    private Date date_ajout;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Stockage stockage;
    @ManyToOne
    private Entropot entropot;
}
