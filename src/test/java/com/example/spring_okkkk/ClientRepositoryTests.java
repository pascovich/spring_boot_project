package com.example.spring_okkkk;

import com.example.spring_okkkk.Client.Client;
import com.example.spring_okkkk.Client.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ClientRepositoryTests {
    @Autowired private ClientRepository repo;
    @Test
    public void testAddNew(){
        Client client = new Client();
        client.setAdresse("kaluzipascovich@gmail.com");
        client.setDescribe_menage("moyen");
        client.setNom("pascovich");
        client.setAdresse("goma");
        client.setSexe("masculin");
        client.setPostnom("kaluzi");
        client.setPrenom("blaise");
        client.setTelephone("0970267037");

        repo.save(client);
       // Client savedClient = repo.save(client);


        //Assertions.assertThat(savedClient).isnot
    }
}
