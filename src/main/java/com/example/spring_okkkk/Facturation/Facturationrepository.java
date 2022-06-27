package com.example.spring_okkkk.Facturation;

import com.example.spring_okkkk.Client.Show_vue;
import com.example.spring_okkkk.Consommation.Consommation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface Facturationrepository extends CrudRepository<Facturation,Integer> {
    public long countById(Integer id);

    @Query(value = "SELECT consommations.montant_tot FROM consommations WHERE consommations.id=?",nativeQuery = true)
    public  float total(int id);

    @Query(value = "SELECT * FROM facturations WHERE facturations.chek_fac_paie=false",nativeQuery = true)
    List<Facturation> listeFacNonfayer();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE consommations SET consommations.chek_cons_fac=true WHERE consommations.id=?",nativeQuery = true)
    public  void upConsetat(int id);
}
