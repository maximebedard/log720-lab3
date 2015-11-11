package ca.etsmtl.log720.lab3;

import java.io.Serializable;

public class Dossier implements Serializable {
    public Dossier(){}

    public Dossier(Integer id, String nom, String prenom, String noPlaque, String noPermis) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.noPlaque = noPlaque;
        this.noPermis = noPermis;
    }

    private Integer id;
    private String nom;
    private String prenom;
    private String noPlaque;
    private String noPermis;

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setNoPlaque(String noPlaque) {
        this.noPlaque = noPlaque;
    }
    public void setNoPermis(String noPermis) {
        this.noPermis = noPermis;
    }

    public Integer getId() {
        return id;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getNom() {
        return nom;
    }
    public String getNoPlaque() {
        return noPlaque;
    }
    public String getNoPermis() {
        return noPermis;
    }

}
