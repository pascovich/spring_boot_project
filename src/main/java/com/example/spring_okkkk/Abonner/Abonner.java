package com.example.spring_okkkk.Abonner;

import javax.persistence.*;


@Entity
@Table(name="abonners")
public class Abonner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String date_abonnement;

    @Column(nullable = false)
    private Integer ref_abonnement;

    @Column(nullable = false)
    private Integer ref_client;

    @Column(nullable = false)
    private Float montant;
}
