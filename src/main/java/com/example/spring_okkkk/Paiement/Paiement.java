package com.example.spring_okkkk.Paiement;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="Paiements")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String motif;

    @Column(nullable = false)
    private String date_paie;

    public String getDate_paie() {
        return date_paie;
    }

    public void setDate_paie(String date_paie) {
        this.date_paie = date_paie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
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

    public Integer getRef_facture() {
        return ref_facture;
    }

    public void setRef_facture(Integer ref_facture) {
        this.ref_facture = ref_facture;
    }

    @Column(nullable = false)
    private Float montant_a_payer;

    @Column(nullable = false)
    private Float montant_payer;
    @Column(nullable = false)
    private Float reste;

    @Column(nullable = false)
    private Integer ref_facture;
}
