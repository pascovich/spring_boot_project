package com.example.spring_okkkk.Client;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 300)
    private String nom;

    @Column(nullable = false, length = 300)
    private String postnom;

    @Column(nullable = true, length = 300)
    private String prenom;

    @Column(nullable = false, length = 30)
    private String sexe;

    @Column(nullable = false, length = 300)
    private String telephone;

    @Column(nullable = true, length = 300)
    private String adresse;

    @Column(columnDefinition ="MEDIUMBLOB")
    private String photo;

    @Column(nullable = true, length = 300)
    private String describe_menage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescribe_menage() {
        return describe_menage;
    }

    public void setDescribe_menage(String describe_menage) {
        this.describe_menage = describe_menage;
    }

}
