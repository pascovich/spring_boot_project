package com.example.spring_okkkk.Facturation;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Facturations")
public class Facturation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String numerofacture;


    @Column(name="date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp date_facture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumerofacture() {
        return numerofacture;
    }

    public void setNumerofacture(String numerofacture) {
        this.numerofacture = numerofacture;
    }

    public Timestamp getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(Timestamp date_facture) {
        this.date_facture = date_facture;
    }

    public Integer getRef_consommation() {
        return ref_consommation;
    }

    public void setRef_consommation(Integer ref_consommation) {
        this.ref_consommation = ref_consommation;
    }

    public Float getMontant_facture() {
        return montant_facture;
    }

    public void setMontant_facture(Float montant_facture) {
        this.montant_facture = montant_facture;
    }

    public boolean isChek_fac_paie() {
        return chek_fac_paie;
    }

    public void setChek_fac_paie(boolean chek_fac_paie) {
        this.chek_fac_paie = chek_fac_paie;
    }

    @Column(nullable = false)
    private Integer ref_consommation;

    @Column(nullable = false)
    private Float montant_facture;

    @Column(nullable = false)
    private Float reste_fac;

    public Float getReste_fac() {
        return reste_fac;
    }

    public void setReste_fac(Float reste_fac) {
        this.reste_fac = reste_fac;
    }

    @Column(nullable = false)
    private boolean chek_fac_paie;

}
