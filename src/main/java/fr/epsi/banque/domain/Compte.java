package fr.epsi.banque.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private double solde;

    @OneToMany(mappedBy = "compte")
    private Set<Operation> operations;

    @ManyToMany
    @JoinTable(
            name = "AssoClientsCommpte",
            joinColumns=@JoinColumn(name = "com_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "cli_id",referencedColumnName = "id")
    )
    private Set<Client> clients;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Set<Operation> getOperatins() {
        return operations;
    }

    public void setOperatins(Set<Operation> operatins) {
        this.operations = operatins;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public Compte() {}

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
    }
}
