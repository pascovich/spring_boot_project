package com.example.spring_okkkk.Consommation;

import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Facturation.Facturation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsommationRepository extends CrudRepository<Consommation,Integer> {
    public long countById(Integer id);

    @Query(value = "SELECT * FROM consommations WHERE consommations.chek_cons_fac=false",nativeQuery = true)
    List<Consommation> listeConNonPacturer();
}
