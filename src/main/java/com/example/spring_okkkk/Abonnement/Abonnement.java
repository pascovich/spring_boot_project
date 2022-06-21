package com.example.spring_okkkk.Abonnement;


import javax.persistence.*;

@Entity
@Table(name="abonnements")
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 300)
    private String type_abonnement;

    @Column(nullable = false, length = 300)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_abonnement() {
        return type_abonnement;
    }

    public void setType_abonnement(String type_abonnement) {
        this.type_abonnement = type_abonnement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
