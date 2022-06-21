package com.example.spring_okkkk.Consommation;

import javax.persistence.*;

@Entity
@Table(name="consommations")
public class Consommation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Float puissance;

    @Column(nullable = false)
    private Float pu;

    @Column(nullable = false, length = 300)
    private String mois;

    @Column(nullable = false, length = 300)
    private String annee;

    @Column(nullable = false)
    private Integer ref_abonner;

    @Column(nullable = false)
    private Boolean chek_cons_paie;

}
