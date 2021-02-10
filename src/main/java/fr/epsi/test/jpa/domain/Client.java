package fr.epsi.test.jpa.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    @OneToMany @JoinColumn(name = "ID_CLIENT",referencedColumnName = "ID")
    private Set<Emprunt> emprunts;

    public Set<Emprunt> getEmprunts() {
        return emprunts;
    }
}
