package com.example.spring_okkkk;

import com.example.spring_okkkk.Facturation.Facturation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PdfFactureRepository extends CrudRepository<VueFactute,Integer> {
    //@Query(value = "SELECT * from facturations WHERE facturations.id=?",nativeQuery = true)
    @Query(value = "SELECT facturations.id,facturations.numerofacture,facturations.montant_facture,facturations.chek_fac_paie,facturations.date,consommations.annee,consommations.mois,consommations.puissance,consommations.pu from facturations \n" +
            "INNER JOIN consommations on facturations.ref_consommation=consommations.id\n" +
            "WHERE facturations.id=?",nativeQuery = true)
    //Iterable<Facturation> facturer(int id);
    Iterable<VueFactute> facturer(int id);



}
