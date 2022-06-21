package com.example.spring_okkkk.Consommation;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Consommation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 300)
    private String nom;

    @Column(nullable = false)
    private Float puissance;

    @Column(nullable = false)
    private Float pu;
}
