package ca.etsmtl.log720.lab3.models;

import javax.persistence.*;

@Entity
@Table(name = "infraction_dossiers")
public class InfractionDossier {

    int id;
    Dossier dossier;
    Infraction infraction;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="dossier_id")
    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    @ManyToOne
    @JoinColumn(name="infraction_id")
    public Infraction getInfraction() {
        return infraction;
    }

    public void setInfraction(Infraction infraction) {
        this.infraction = infraction;
    }
}
