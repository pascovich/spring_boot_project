package com.example.spring_okkkk;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="VueFactute")
public class VueFactute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String numerofacture;
    @Column(nullable = false)
    private Float montant_facture;
    @Column(nullable = false)
    private Boolean chek_fac_paie;
    @Column(name="date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp date;
    @Column(nullable = false)
    private String annee;

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

    public Float getMontant_facture() {
        return montant_facture;
    }

    public void setMontant_facture(Float montant_facture) {
        this.montant_facture = montant_facture;
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

    @Column(nullable = false)
    private String mois;
    @Column(nullable = false)
    private Integer puissance;
    @Column(nullable = false)
    private Float pu;

}
