package com.example.spring_okkkk.Abonnement;

import com.example.spring_okkkk.Client.Client;
import org.springframework.data.repository.CrudRepository;

public interface AbonnementRepository extends CrudRepository<Abonnement,Integer> {
    public long countById(Integer id);
}
