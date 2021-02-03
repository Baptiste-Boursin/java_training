package epsi.test.jpa.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE_DEBUT")
    private Date date_debut;

    @Column(name = "DATE_FIN")
    private Date date_fin;

    @Column(name = "DELAI")
    private int delai;


    @Column(name = "ID_CLIENT")
    private int id_client;

    @ManyToMany(mappedBy = "emprunts")
    private Set<Livre> livres;

    public int getId_client() {
        return id_client;
    }

    public Set<Livre> getLivres() {
        return livres;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", date_debut=" + date_debut +
                ", date_fin=" + date_fin +
                ", delai=" + delai +
                ", id_client=" + id_client +
                ", livres=" + livres.toString() +
                '}';
    }
}
