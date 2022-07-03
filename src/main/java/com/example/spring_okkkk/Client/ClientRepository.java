package com.example.spring_okkkk.Client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client,Integer>{
    public long countById(Integer id);
    @Query(value = "SELECT clients.id,`adresse`, `describe_menage`, `nom`, `photo`, `postnom`, `prenom`, `sexe`, `telephone` from clients inner join abonners on abonners.ref_client=clients.id inner join consommations on consommations.ref_abonner=abonners.id inner join facturations on facturations.ref_consommation=consommations.id where facturations.id=?;",nativeQuery = true)
    List<Client> nom(int id);

}
