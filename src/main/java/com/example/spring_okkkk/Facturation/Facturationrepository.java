package com.example.spring_okkkk.Facturation;

import com.example.spring_okkkk.Consommation.Consommation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Facturationrepository extends CrudRepository<Facturation,Integer> {
    public long countById(Integer id);

    @Query(value = "SELECT consommations.montant_tot FROM consommations WHERE consommations.id=?",nativeQuery = true)
    public  float total(int id);

}
