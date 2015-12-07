package ca.etsmtl.log720.lab3.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "infractions")
public class Infraction {
    private int id;
    private String description;
    private Integer gravite;

    @OneToMany(mappedBy = "infraction", orphanRemoval = true)
    public List<InfractionDossier> getInfractionDossiers() {
        return infractionDossiers;
    }

    public void setInfractionDossiers(List<InfractionDossier> infractionDossiers) {
        this.infractionDossiers = infractionDossiers;
    }

    private List<InfractionDossier> infractionDossiers = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGravite(Integer gravite) { this.gravite = gravite; }

    @Column(name = "gravite")
    public Integer getGravite() { return gravite; }

    public void setDescription(String description) { this.description = description; }

    @Column(name = "description")
    public String getDescription() { return description; }
}
