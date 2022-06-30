package com.example.spring_okkkk.Client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShowRepository extends CrudRepository<Show_vue,Integer> {
    @Query(value = "SELECT clients.id as id_client, clients.nom,clients.postnom,clients.prenom, facturations.numero_facture,consommations.annee,consommations.mois,facturations.date as date_facturation,facturations.chek_fac_paie,consommations.pu,consommations.puissance,consommations.montant_tot,facturations.reste_fac as reste_a_payer FROM `facturations` \n" +
            "inner JOIN consommations on facturations.ref_consommation=consommations.id \n" +
            "INNER JOIN abonners on consommations.ref_abonner=abonners.id\n" +
            "INNER join clients on abonners.ref_client=clients.id\n" +
            "INNER join abonnements on abonners.ref_abonnement=abonnements.id WHERE clients.id=?",nativeQuery = true)
    List<Show_vue> liste(Integer id);
}
