package com.example.spring_okkkk;

import com.example.spring_okkkk.Abonnement.Abonnement;
import com.example.spring_okkkk.Client.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IndexRepository extends CrudRepository<Client,Integer> {
    @Query(value = "SELECT count(id) from clients",nativeQuery = true)
    public int DashClients();
}
