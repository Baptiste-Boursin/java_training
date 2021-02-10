package fr.epsi.banque.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
@Entity
@DiscriminatorValue("LA")
public class LivretA extends Compte {

    private double taux;

    public LivretA() {
    }

    public LivretA(String numero, double solde, double taux) {
        super(numero, solde);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
