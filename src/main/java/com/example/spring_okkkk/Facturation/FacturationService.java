package com.example.spring_okkkk.Facturation;

import com.example.spring_okkkk.Consommation.Consommation;
import com.example.spring_okkkk.Consommation.ConsommationRepository;
import com.example.spring_okkkk.eleve.Eleve;
import com.example.spring_okkkk.eleve.EleveR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturationService {
    @Autowired
    private Facturationrepository repo;

    public List<Facturation> facturationsAll(){
        return (List<Facturation>) repo.findAll();
    }

    public void save(Facturation facturation) {
        repo.save(facturation);
    }

    @Autowired
    Facturationrepository repo_fac;
    public void insererfacuration(String num_fac,Integer ref_consommation,Float montant){
        Facturation e = new Facturation();
        e.setNumerofacture(num_fac);
        e.setRef_consommation(ref_consommation);
        e.setMontant_facture(montant);
        e.setChek_fac_paie(false);
        e.setReste_fac(montant);
        repo_fac.save(e);
    }
}
