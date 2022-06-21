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
}
