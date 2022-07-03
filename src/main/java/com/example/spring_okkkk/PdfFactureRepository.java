package com.example.spring_okkkk;

import com.example.spring_okkkk.Facturation.Facturation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PdfFactureRepository extends CrudRepository<Facturation,Integer> {
    @Query(value = "SELECT * from facturations WHERE facturations.id=?",nativeQuery = true)
    Iterable<Facturation> facturer(int id);

}
