package fr.epsi.banque.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Banque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;

    @OneToMany(mappedBy = "banque")//nom de l'attribut représentant la banque dans CLient
    private Set<Client> clients;

    public Banque() {
    }

    public Banque(String nom) {
        this.nom = nom;
    }

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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
