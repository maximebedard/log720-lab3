package ca.etsmtl.log720.lab3.models;


import javax.persistence.*;

@Entity
@Table(name = "infractions")
public class Infraction {
    private int id;
    private String description;
    private Integer gravite;

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
