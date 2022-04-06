/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

/**
 *
 * @author jules
 */
public class Lien {
    
    private Noeud noeudD;
    private Noeud noeudA;
    private String type;
    private int longueur;

    public Lien(Noeud noeudD, Noeud noeudA, String type, int longueur) {
        this.noeudD = noeudD;
        this.noeudA = noeudA;
        this.type = type;
        this.longueur = longueur;
    }

    @Override
    public String toString() {
        return "Lien{" + "nomD=" + noeudD + ", nomA=" + noeudA + ", type=" + type + ", longueur=" + longueur + '}';
    }

    public Noeud getNomD() {
        return noeudD;
    }

    public Noeud getNomA() {
        return noeudA;
    }

    public String getType() {
        return type;
    }

    public int getLongueur() {
        return longueur;
    }
    
    
    
}
