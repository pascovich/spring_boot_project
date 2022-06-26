package com.example.spring_okkkk.Client;

import javax.persistence.*;

@Entity
@Table(name="Vue_cp")
public class Show_vue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_paie;

    @Column(nullable = false)
    private String date_paie ;

    @Column(nullable = false)
    private Float montant_a_payer;

    @Column(nullable = false)
    private Float montant_payer;

    @Column(nullable = false)
    private Float reste;

    @Column(nullable = false)
    private String numero_facture;

    @Column(nullable = false)
    private boolean chek_fac_paie;

    @Column(nullable = false)
    private Integer annee;

    @Column(nullable = false)
    private String mois;

    @Column(nullable = false)
    private Float puissance;

    @Column(nullable = false)
    private Float pu;

    public Integer getId_paie() {
        return id_paie;
    }

    public void setId_paie(Integer id_paie) {
        this.id_paie = id_paie;
    }

    public String getDate_paie() {
        return date_paie;
    }

    public void setDate_paie(String date_paie) {
        this.date_paie = date_paie;
    }

    public Float getMontant_a_payer() {
        return montant_a_payer;
    }

    public void setMontant_a_payer(Float montant_a_payer) {
        this.montant_a_payer = montant_a_payer;
    }

    public Float getMontant_payer() {
        return montant_payer;
    }

    public void setMontant_payer(Float montant_payer) {
        this.montant_payer = montant_payer;
    }

    public Float getReste() {
        return reste;
    }

    public void setReste(Float reste) {
        this.reste = reste;
    }

    public String getNumero_facture() {
        return numero_facture;
    }

    public void setNumero_facture(String numero_facture) {
        this.numero_facture = numero_facture;
    }

    public boolean isChek_fac_paie() {
        return chek_fac_paie;
    }

    public void setChek_fac_paie(boolean chek_fac_paie) {
        this.chek_fac_paie = chek_fac_paie;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Float getPuissance() {
        return puissance;
    }

    public void setPuissance(Float puissance) {
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

    @Column(nullable = false)
    private Float montant_tot;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String postnom;
}
