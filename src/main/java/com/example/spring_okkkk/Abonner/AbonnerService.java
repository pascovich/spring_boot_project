package com.example.spring_okkkk.Abonner;

import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientRepository;
import com.example.spring_okkkk.eleve.Eleve;
import com.example.spring_okkkk.eleve.EleveR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnerService {
    @Autowired
    private AbonnerRepository repo;

    public List<Abonner> abonnerssAll(){
        return (List<Abonner>) repo.findAll();
    }


    public void save(Abonner abonner) {
        repo.save(abonner);
    }

    @Autowired
    AbonnerRepository repo_abonner;
    public void insererabonner(String date_abonner,Integer ref_client,Integer ref_abonnement,Float montant){
        Abonner e = new Abonner();
        e.setDate_abonnement(date_abonner);
        e.setRef_client(ref_client);
        e.setRef_abonnement(ref_abonnement);
        e.setMontant(montant);
        repo_abonner.save(e);
    }
}
