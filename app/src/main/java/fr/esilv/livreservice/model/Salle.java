package fr.esilv.livreservice.model;

public class Salle {
    private String ville;
    private int numSalle;

    public Salle(String ville, int numSalle) {
        this.ville = ville;
        this.numSalle = numSalle;
    }

    public String getVille() {
        return ville;
    }

    public int getNumSalle() {
        return numSalle;
    }
}
