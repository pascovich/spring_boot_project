package com.example.spring_okkkk.Facturation;

import javax.persistence.*;

@Entity
@Table(name="Facturations")
public class Facturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String numero_facture;

    @Column(nullable = false)
    private String date_facture;

    @Column(nullable = false)
    private Integer ref_consommation;

    @Column(nullable = false)
    private Float montant_facture;

    @Column(nullable = false)
    private boolean chek_fac_paie;

}
