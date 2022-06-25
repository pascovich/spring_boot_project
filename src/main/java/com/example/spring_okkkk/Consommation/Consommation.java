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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Integer getRef_abonner() {
        return ref_abonner;
    }

    public void setRef_abonner(Integer ref_abonner) {
        this.ref_abonner = ref_abonner;
    }

    public Boolean getChek_cons_fac() {
        return chek_cons_fac;
    }

    public void setChek_cons_fac(Boolean chek_cons_fac) {
        this.chek_cons_fac = chek_cons_fac;
    }

    @Column(nullable = false)
    private String mois;

    @Column(nullable = false)
    private Integer annee;

    @Column(nullable = false)
    private Integer ref_abonner;

    @Column(nullable = false)
    private Boolean chek_cons_fac;

    @Column(nullable = false)
    private Float montant_tot;

    public Float getMontant_tot() {
        return montant_tot;
    }

    public void setMontant_tot(Float montant_tot) {
        this.montant_tot = montant_tot;
    }
}
