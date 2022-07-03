package com.example.spring_okkkk.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.util.StringUtils;
@Service
public class ClientService {
    @Autowired private ClientRepository repo;

    public List<Client> clientsAll(){
        return (List<Client>) repo.findAll();
    }

    public void save(Client client) {
        repo.save(client);
    }
    public Client get(Integer id) throws ClientNotFoundException {
        Optional<Client> result=repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ClientNotFoundException("on ne peut pas trouver le client ID="+id);
    }
    public void delete(Integer id) throws ClientNotFoundException {
        Long count = repo.countById(id);
        if(count==null || count==0){
            throw new ClientNotFoundException("on ne peut pas trouver le client ID="+id);
        }
        repo.deleteById(id);
    }
    public void insert(String nom,String postnom,String prenom,String sexe,String telephone,String adresse,String describe_menage, MultipartFile filep){
        Client e =new Client();

        String filename= StringUtils.cleanPath(filep.getOriginalFilename());
        if(filename.contains("..")){
            System.err.println("not a valid");
        }
        try{
            e.setPhoto(Base64.getEncoder().encodeToString(filep.getBytes()));
        }
        catch (IOException s)
        {
            throw new RuntimeException(s);
        }
        e.setNom(nom);
        e.setPostnom(postnom);
        e.setPrenom(prenom);
        e.setSexe(sexe);
        e.setTelephone(telephone);
        e.setAdresse(adresse);
        e.setDescribe_menage(describe_menage);
        repo.save(e);
    }

}
