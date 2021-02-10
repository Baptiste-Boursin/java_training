package fr.epsi.banque.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
public class Client implements Serializable {

    public enum Genre{
        M,F,O;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Embedded
    private Adresse adresse;

    @ManyToMany(mappedBy = "clients",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Compte> comptes;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="banque_id")
    private Banque banque;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Client() {
    }

    public Client(String nom, String prenom, LocalDate dateNaissance, Genre genre, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.adresse = adresse;
    }
}
