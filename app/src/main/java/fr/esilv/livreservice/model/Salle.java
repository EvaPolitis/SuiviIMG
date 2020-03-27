package fr.esilv.livreservice.model;

public class Salle {
    private String ville;
    private String numSalle;
    //private int imageResource;

    public Salle(String ville, String numSalle) {
       // this.imageResource = imageResource;
        this.ville = ville;
        this.numSalle = numSalle;
    }

    /*public int getImageResource() {
        return imageResource;
    }*/

    public String getVille() {
        return ville;
    }

    public String getNumSalle() {
        return numSalle;
    }
}
