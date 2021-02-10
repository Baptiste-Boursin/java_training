package fr.epsi.test.jpa.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LIVRE")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITRE")
    private String titre;

    @Column(name = "AUTEUR")
    private String auteur;

    @ManyToMany
    @JoinTable(name = "COMPO",
            joinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_EMP",referencedColumnName = "ID")
    )
    private Set<Emprunt> emprunts;

    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
