package fr.epsi.banque;

import fr.epsi.banque.domain.Adresse;
import fr.epsi.banque.domain.Banque;
import fr.epsi.banque.domain.Client;
import fr.epsi.banque.domain.Compte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;


public class TestBanque {

    public static void main(String[] args) {

        createClient();

    }

    private static void createClient() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-banque");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Adresse adresse = new Adresse(12,"rue Kercouret",44410,"Herbignac");
        Client client = new Client("Boursin","Baptiste", LocalDate.of(2000,06,23), Client.Genre.M,adresse);
       /* Banque banque = new Banque("Crédit Agricole");
            client.setBanque(banque);
        */
        em.persist(client);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
