package com.example.spring_okkkk.Consommation;

import com.example.spring_okkkk.Abonner.Abonner;
import com.example.spring_okkkk.Abonner.AbonnerRepository;
import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsommationService {
    @Autowired
    private ConsommationRepository repo;

    public List<Consommation> consommationsAll(){
        return (List<Consommation>) repo.findAll();
    }

    public void save(Consommation consommation) {
        repo.save(consommation);
    }

    @Autowired
    ConsommationRepository repo_cons;
    public void insererconsommation(Integer annee,String mois,Float pu,Float puissance,Integer ref_abonner){
        Consommation e = new Consommation();
        e.setAnnee(annee);
        e.setMois(mois);
        e.setPu(pu);
        e.setPuissance(puissance);
        e.setRef_abonner(ref_abonner);
        e.setChek_cons_fac(false);

        Float puu;
        puu = e.getPu();
        Float puissancee;
        puissancee = e.getPuissance();
        Float pt = puu * puissancee;

        e.setMontant_tot(pt);
        repo_cons.save(e);
    }
}
