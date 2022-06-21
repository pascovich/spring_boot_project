package com.example.spring_okkkk.Abonnement;

import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementService {
    @Autowired
    private AbonnementRepository repo;

    public List<Abonnement> abnnementAll(){
        return (List<Abonnement>) repo.findAll();
    }

    public void save(Abonnement abonnement) {
        repo.save(abonnement);
    }
}
