package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name="entropot")
public class Entropot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String capaciteTotal;
    private float prix;
    private int nombreRayon;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numRayon;*/
    private int nombreEtage;
    private int nombreCas;
    private String adress;
    private String responsable;
    @OneToMany(mappedBy = "entropot")
    private Collection<product> products;
}
