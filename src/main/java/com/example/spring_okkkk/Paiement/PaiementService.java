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
    @Autowired
    private Facturationrepository repo_fac;

    public List<Paiement> paiementsAll(){
        return (List<Paiement>) repo.findAll();
    }

//    public void save(Paiement paiement) {
//        repo.save(paiement);
//    }


    @Autowired
    PaiementRepository repo_paie;
    public void insererPaiement(String date_paie,Integer ref_facture,String motif,Float prix_a_payer,Float prix_payer,Float prixpayer){
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
//update reste a payer
//        Facturation ex = new Facturation();
//        Float prix = prixpayer;
//        Float re = reste;
//        Float r = reste - prix;
//        ex.setReste_fac(r);
//        repo_fac.save(ex);
    }
//    public void updateFac(Integer ref_fac){
//        Facturation e = new Facturation();
//        e.setChek_fac_paie(true);
//        repo_fac.save(e);
//    }
//    public void upfacreste(Float reste,Float prixpayer){
//        Facturation e = new Facturation();
//        Float prix = prixpayer;
//        Float re = reste;
//        Float r = reste - prix;
//        e.setReste_fac(r);
//        repo_fac.save(e);
//    }
}
