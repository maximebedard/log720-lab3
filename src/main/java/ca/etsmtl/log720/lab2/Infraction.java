package ca.etsmtl.log720.lab3;

public class Infraction {

    private int id;
    private String description;
    private int gravite;

    public Infraction() {}
    public Infraction(int id, String description, int gravite) {
        this.id = id;
        this.description = description;
        this.gravite = gravite;
    }

    public int getId() {
        return id;
    }
    public int getGravite() {
        return gravite;
    }
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setGravite(int gravite) {
        this.gravite = gravite;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Infraction that = (Infraction) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
