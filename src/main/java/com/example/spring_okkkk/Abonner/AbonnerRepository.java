package com.example.spring_okkkk.Abonner;

import com.example.spring_okkkk.Client.Client;
import org.springframework.data.repository.CrudRepository;

public interface AbonnerRepository extends CrudRepository<Abonner,Integer> {
    public long countById(Integer id);
}
