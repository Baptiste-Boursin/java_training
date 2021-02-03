package epsi.test.jpa;

import epsi.test.jpa.domain.Livre;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-essai");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        /*

        // Affichage du livre qui a pour id 1

        Livre livre = em.find(Livre.class,1);
        if(livre!=null){
            System.out.println(" id : "+livre.getId() +"\n titre : "+livre.getTitre()+"\n auteur : "+livre.getAuteur());
        }

        // Ajout d'un livre

        Livre newlivre = new Livre();
        newlivre.setTitre("Les fables de la Fontaine");
        newlivre.setAuteur("Jean de la Fontaine");
        em.persist(newlivre);

        // Modification du titre du livre 5

        Livre updateLivre = em.find(Livre.class,5);
        if(updateLivre!=null){
            updateLivre.setTitre("Du plaisir dans la cuisine");
            System.out.println(updateLivre.getTitre());
        }

        // Récupération d'un livre par son titre

        TypedQuery<Livre> reqLivreTitle = em.createQuery("select l from Livre l where l.titre='Les fables de la Fontaine'", Livre.class);
        Livre livreReq = reqLivreTitle.getResultList().get(0);
        if(livreReq!=null){
            System.out.println(livreReq.getAuteur());
        }*/

        // récupérer unlivre par son titre

        /*
        TypedQuery<Livre> reqLivreAutor = em.createQuery("select l from Livre l where l.auteur='Jean de la Fontaine'", Livre.class);
        Livre livreReq = reqLivreAutor.getResultList().get(0);
        if(livreReq!=null){
            System.out.println(livreReq.getTitre());
        }

        // Suppression d'un livre

        Livre livreDelete = em.find(Livre.class,6);
        if(livreDelete!=null){
            em.remove(livreDelete);
        }*/

        //affichage de tous les livres présents dans la base de données
        List<Livre> listLivres = em.createQuery("Select l from Livre l ",Livre.class).getResultList();
        for (Livre livre:listLivres
             ) {
            System.out.println(" titre : "+livre.getTitre()+"\n auteur : "+livre.getAuteur());
            System.out.println("----------------------");
        }

        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
