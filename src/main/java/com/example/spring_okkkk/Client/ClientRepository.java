package com.example.spring_okkkk.Client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Integer>{
    public long countById(Integer id);


}
