package com.example.spring_okkkk.Abonnement;

import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.Show_vue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AbonnementRepository extends CrudRepository<Abonnement,Integer> {
    public long countById(Integer id);

    @Query(value = "SELECT * from abonnements where id=?",nativeQuery = true)
    List<Abonnement> listeAb(int id);
}
