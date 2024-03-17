package com.example.projet_spring.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="emballage")
public class Emballage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type_emballage;
    private String taille;
    private int point;
    private int cout;
    private String effecacite;
}
