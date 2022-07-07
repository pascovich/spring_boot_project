package com.example.spring_okkkk;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PdfNotPayedRepository extends CrudRepository<VueFactureNotPayed,Integer> {
    @Query(value = "SELECT facturations.id,facturations.chek_fac_paie,facturations.date,facturations.montant_facture,facturations.numerofacture,facturations.reste_fac,clients.nom,clients.postnom,clients.prenom,consommations.mois,consommations.annee,consommations.puissance,consommations.pu,consommations.montant_tot FROM facturations\n" +
            "inner join consommations on facturations.ref_consommation=consommations.id\n" +
            "inner join abonners on consommations.ref_abonner=abonners.id\n" +
            "inner join clients on abonners.ref_client=clients.id\n" +
            "inner join abonnements on abonners.ref_abonnement=abonnements.id\n" +
            "WHERE facturations.annee=? AND facturations.chek_fac_paie=false",nativeQuery = true)
    Iterable<VueFactureNotPayed> facturerNotPayed(int annee);
}
