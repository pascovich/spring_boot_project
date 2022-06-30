package com.example.spring_okkkk.Client;

import javax.persistence.*;

@Entity
@Table(name="Vue_cp")
public class Show_vue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_client;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String postnom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String numero_facture;

    public Integer getId_client() {
        return id_client;
    }

    public void setId_client(Integer id_client) {
        this.id_client = id_client;
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

    public String getNumero_facture() {
        return numero_facture;
    }

    public void setNumero_facture(String numero_facture) {
        this.numero_facture = numero_facture;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getDate_facturation() {
        return date_facturation;
    }

    public void setDate_facturation(String date_facturation) {
        this.date_facturation = date_facturation;
    }

    public Float getPu() {
        return pu;
    }

    public void setPu(Float pu) {
        this.pu = pu;
    }

    public Float getPuissance() {
        return puissance;
    }

    public void setPuissance(Float puissance) {
        this.puissance = puissance;
    }

    public Float getMontant_tot() {
        return montant_tot;
    }

    public void setMontant_tot(Float montant_tot) {
        this.montant_tot = montant_tot;
    }

    public Float getReste_a_payer() {
        return reste_a_payer;
    }

    public void setReste_a_payer(Float reste_a_payer) {
        this.reste_a_payer = reste_a_payer;
    }

    public Boolean getChek_fac_paie() {
        return chek_fac_paie;
    }

    public void setChek_fac_paie(Boolean chek_fac_paie) {
        this.chek_fac_paie = chek_fac_paie;
    }

    @Column(nullable = false)
    private String annee;

    @Column(nullable = false)
    private String mois;

    @Column(nullable = false)
    private String date_facturation;

    @Column(nullable = false)
    private Float pu;

    @Column(nullable = false)
    private Float puissance;

    @Column(nullable = false)
    private Float montant_tot;

    @Column(nullable = false)
    private Float reste_a_payer;

    @Column(nullable = false)
    private Boolean chek_fac_paie;

}
