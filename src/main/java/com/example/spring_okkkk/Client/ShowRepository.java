package com.example.spring_okkkk.Client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowRepository extends CrudRepository<Show_vue,Integer> {
    @Query(value = "SELECT paiements.id as id_paie,date_paie,montant_a_payer,montant_payer,reste,facturations.numero_facture,facturations.chek_fac_paie,consommations.annee,consommations.mois,consommations.puissance,consommations.pu,consommations.montant_tot,clients.nom,clients.postnom FROM `paiements` inner join facturations on paiements.ref_facture=facturations.id\n" +
            "inner join consommations on facturations.ref_consommation=consommations.id\n" +
            "inner join abonners on consommations.ref_abonner=abonners.id\n" +
            "inner join abonnements on abonnements.id=abonners.ref_abonnement\n" +
            "inner join clients on clients.id=abonners.ref_client where clients.id=?",nativeQuery = true)
    List<Show_vue> liste(Integer id);
}
