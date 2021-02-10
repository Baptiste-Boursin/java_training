package fr.epsi.banque.domain;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("AV")
public class AssuranceVie extends Compte{

    private LocalDate dateFin;
    private double taux;

    public AssuranceVie() {
    }

    public AssuranceVie(String numero, double solde, LocalDate dateFin, double taux) {
        super(numero, solde);
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
