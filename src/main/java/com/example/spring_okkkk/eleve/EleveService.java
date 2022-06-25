package com.example.spring_okkkk.eleve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EleveService {
    @Autowired EleveR eleveR;
    public void inserereleve(String nom){
        Eleve e = new Eleve();
        e.setNom(nom);
        eleveR.save(e);
    }
}
