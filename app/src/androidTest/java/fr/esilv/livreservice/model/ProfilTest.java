package fr.esilv.livreservice.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilTest {

    private Profil profil = new Profil(67,165,35,0);
    private float img=(float)32.2;
    private String message="trop élevé";
    @Test
    public void getImg() throws Exception {
        assertEquals(img,profil.getImg(),(float)0.1);
    }

    @Test
    public void getMessage() throws Exception {
        assertEquals(message,profil.getMessage());
    }
}