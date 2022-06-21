package com.example.spring_okkkk.Paiement;

import com.example.spring_okkkk.Facturation.Facturation;
import org.springframework.data.repository.CrudRepository;

public interface PaiementRepository extends CrudRepository<Paiement,Integer> {
    public long countById(Integer id);
}
