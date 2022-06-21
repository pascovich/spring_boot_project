package com.example.spring_okkkk.Consommation;

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
}
