package com.example.spring_okkkk.Facturation;

import com.example.spring_okkkk.Consommation.Consommation;
import com.example.spring_okkkk.Consommation.ConsommationRepository;
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
}
