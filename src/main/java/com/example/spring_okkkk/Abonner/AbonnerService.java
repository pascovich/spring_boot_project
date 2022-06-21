package com.example.spring_okkkk.Abonner;

import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientRepository;
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
}
