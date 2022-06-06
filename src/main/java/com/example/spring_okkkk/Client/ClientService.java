package com.example.spring_okkkk.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired private ClientRepository repo;

    public List<Client> clientsAll(){
        return (List<Client>) repo.findAll();
    }
}
