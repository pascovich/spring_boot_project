package com.example.spring_okkkk;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="VueFactuteNotPayed")
public class VueFactureNotPayed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Boolean chek_fac_paie;

    @Column(name="date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp date;

    @Column(nullable = false)
    private Float montant_facture;

    @Column(nullable = false)
    private String numerofacture;

    @Column(nullable = false)
    private Float reste_fac;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String postnom;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getChek_fac_paie() {
        return chek_fac_paie;
    }

    public void setChek_fac_paie(Boolean chek_fac_paie) {
        this.chek_fac_paie = chek_fac_paie;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Float getMontant_facture() {
        return montant_facture;
    }

    public void setMontant_facture(Float montant_facture) {
        this.montant_facture = montant_facture;
    }

    public String getNumerofacture() {
        return numerofacture;
    }

    public void setNumerofacture(String numerofacture) {
        this.numerofacture = numerofacture;
    }

    public Float getReste_fac() {
        return reste_fac;
    }

    public void setReste_fac(Float reste_fac) {
        this.reste_fac = reste_fac;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Integer getPuissance() {
        return puissance;
    }

    public void setPuissance(Integer puissance) {
        this.puissance = puissance;
    }

    public Float getPu() {
        return pu;
    }

    public void setPu(Float pu) {
        this.pu = pu;
    }

    public Float getMontant_tot() {
        return montant_tot;
    }

    public void setMontant_tot(Float montant_tot) {
        this.montant_tot = montant_tot;
    }

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String mois;

    @Column(nullable = false)
    private String annee;

    @Column(nullable = false)
    private Integer puissance;

    @Column(nullable = false)
    private Float pu;

    @Column(nullable = false)
    private Float montant_tot;

}
