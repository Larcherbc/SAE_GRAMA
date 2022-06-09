/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

import java.util.Objects;

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
        return "nomD=" + noeudD.getNom() + ", nomA=" + noeudA.getNom() + ", type=" + type + ", taille=" + longueur;
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
    
    public void afficheInfo(){
        System.out.println("Ce lien relie le " + this.getNomD() + "et le " + this.getNomD());
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.noeudD);
        hash = 59 * hash + Objects.hashCode(this.noeudA);
        hash = 59 * hash + Objects.hashCode(this.type);
        hash = 59 * hash + this.longueur;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lien other = (Lien) obj;
        if (this.longueur != other.longueur) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (Objects.equals(this.noeudD, other.noeudA)) {
            return true;
        }
        if (Objects.equals(this.noeudA, other.noeudD)) {
            return true;
        }
        if (!Objects.equals(this.noeudD, other.noeudD)) {
            return false;
        }
        return Objects.equals(this.noeudA, other.noeudA);
    }

    
    
    
}
