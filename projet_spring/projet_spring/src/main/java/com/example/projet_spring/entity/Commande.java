package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Data
@Entity
@Table(name="commande")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameClient;
    private String num_tel;
    private String adress;
    private int Quantit_produit;
    @OneToMany(mappedBy = "commande")
    private Collection<product> products;

}
