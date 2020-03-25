package fr.esilv.livreservice.controller;

import fr.esilv.livreservice.model.Profil;

public final class Control {

    private static Control instance=null;

    private Profil profil;

    /**
     * constructeur privé
     */
    private Control(){
        super();
    }

    /**
     * Création de l'instance
     * @return instance
     */
    public static final Control getInstance(){
        if(Control.instance==null){
            Control.instance=new Control();
        }
        return Control.instance;
    }

    /**
     * Création du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 0 femme, 1 homme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe){
        profil=new Profil(poids,taille,age,sexe);
    }

    /**
     * Recuperation img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * recuperation du message
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }
}
