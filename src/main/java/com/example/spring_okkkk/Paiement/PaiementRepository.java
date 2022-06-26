package com.example.spring_okkkk.Paiement;

import com.example.spring_okkkk.Facturation.Facturation;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface PaiementRepository extends CrudRepository<Paiement,Integer> {
    public long countById(Integer id);

    @Query(value = "SELECT facturations.montant_facture FROM facturations WHERE facturations.id=?",nativeQuery = true)
    public  float montantApayer(int id);

    @Query(value = "SELECT facturations.reste_fac FROM facturations WHERE facturations.id=?",nativeQuery = true)
    public  float reste_fac(int id);

//    @Query(value = "UPDATE facturations SET facturations.chek_fac_paie=true WHERE facturations.id=?",nativeQuery = true)
//    public  void upfac(int id);
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE  facturations SET facturations.reste_fac=?  WHERE facturations.id=?",nativeQuery = true)
    public  void upreste(float new_reste,int id);
}
