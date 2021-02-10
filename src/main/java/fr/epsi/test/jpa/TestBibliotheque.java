package fr.epsi.test.jpa;

import fr.epsi.test.jpa.domain.Client;
import fr.epsi.test.jpa.domain.Emprunt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBibliotheque {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-essai");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*Emprunt emprunt = em.find(Emprunt.class,1);
        if(emprunt!=null){
            System.out.println(emprunt.toString());
        }*/

        Client client = em.find(Client.class,1);
        if(client!=null){
            System.out.println(client.getEmprunts().toString());
        }
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
