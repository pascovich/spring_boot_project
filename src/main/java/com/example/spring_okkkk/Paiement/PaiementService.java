package com.example.spring_okkkk.Paiement;

import com.example.spring_okkkk.Facturation.Facturation;
import com.example.spring_okkkk.Facturation.Facturationrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository repo;

    public List<Paiement> paiementsAll(){
        return (List<Paiement>) repo.findAll();
    }

    public void save(Paiement paiement) {
        repo.save(paiement);
    }


    @Autowired
    PaiementRepository repo_paie;
    public void insererPaiement(String date_paie,Integer ref_facture,String motif,Float prix_a_payer,Float prix_payer){
        Paiement e = new Paiement();
        e.setDate_paie(date_paie);
        e.setRef_facture(ref_facture);
        e.setMotif(motif);
        e.setMontant_a_payer(prix_a_payer);
        e.setMontant_payer(prix_payer);

        Float papayer;
        papayer = e.getMontant_a_payer();
        Float ppayer;
        ppayer = e.getMontant_payer();
        Float reste = papayer-ppayer;

        e.setReste(reste);
        repo_paie.save(e);
    }
}
