package fr.epsi.banque.domain;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Virement extends Operation{

    private String beneficiaire;


    public Virement() {
    }

    public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }
}
