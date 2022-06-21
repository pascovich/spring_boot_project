package com.example.spring_okkkk.Paiement;

import javax.persistence.*;

@Entity
@Table(name="Facturations")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false)
    private String date_paie;

    @Column(nullable = false)
    private String motiff;

    @Column(nullable = false)
    private Float montant_a_payer;

    @Column(nullable = false)
    private Float montant_payer;

    @Column(nullable = false)
    private Integer ref_facture;
}
