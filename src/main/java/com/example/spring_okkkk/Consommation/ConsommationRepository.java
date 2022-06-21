package com.example.spring_okkkk.Consommation;

import com.example.spring_okkkk.Client.Client;
import org.springframework.data.repository.CrudRepository;

public interface ConsommationRepository extends CrudRepository<Consommation,Integer> {
    public long countById(Integer id);
}
