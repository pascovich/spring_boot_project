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
    private Float montant;

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate_abonnement() {
        return date_abonnement;
    }

    public void setDate_abonnement(String date_abonnement) {
        this.date_abonnement = date_abonnement;
    }

    public Integer getRef_abonnement() {
        return ref_abonnement;
    }

    public void setRef_abonnement(Integer ref_abonnement) {
        this.ref_abonnement = ref_abonnement;
    }

    public Integer getRef_client() {
        return ref_client;
    }

    public void setRef_client(Integer ref_client) {
        this.ref_client = ref_client;
    }

    @Column(nullable = false)
    private Integer ref_abonnement;

    @Column(nullable = false)
    private Integer ref_client;

}
