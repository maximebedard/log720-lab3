package ca.etsmtl.log720.lab3.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "dossiers")
public class Dossier {
    private int id;
    private String nom;
    private String prenom;
    private String noPlaque;
    private String noPermis;
    private List<InfractionDossier> infractionDossiers = new ArrayList<>();

    @OneToMany(mappedBy = "dossier", orphanRemoval = true)
    public List<InfractionDossier> getInfractionDossiers() {
        return infractionDossiers;
    }

    public void setInfractionDossiers(List<InfractionDossier> infractionDossiers) {
        this.infractionDossiers = infractionDossiers;
    }

    public void addInfractionDossier(InfractionDossier infractionDossier) {
        infractionDossier.setDossier(this);
        this.infractionDossiers.add(infractionDossier);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name = "no_plaque")
    public String getNoPlaque() {
        return noPlaque;
    }

    public void setNoPlaque(String noPlaque) {
        this.noPlaque = noPlaque;
    }

    @Column(name = "no_permis")
    public String getNoPermis() {
        return noPermis;
    }

    public void setNoPermis(String noPermis) {
        this.noPermis = noPermis;
    }
}
