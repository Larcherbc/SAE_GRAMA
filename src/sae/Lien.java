/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

import java.util.Objects;
import ressource.TypeLien;

/**
 *Cette classe permet définir ce qu'est un lien. Un lien possède un {@link Noeud} de départ, un {@link Noeud} d'arrivée, un {@link TypeLien type} et une longueur
 * @author jules Rabec
 */
public class Lien {
    
    private final Noeud noeudD;
    private final Noeud noeudA;
    private final TypeLien type;
    private final int longueur;

    /**
     * permet de créer un lien qui part d'un {@link Noeud} puis arrive a un autre {@link Noeud}, a un {@link TypeLien type} et une longueur.
     * @param noeudD Correspond au {@link Noeud} de départ
     * @param noeudA Correspond au {@link Noeud} d'arrivée
     * @param type Correspond au {@link TypeLien type} du lien
     * @param longueur Correspond a la longueur du lien
     */
    public Lien(Noeud noeudD, Noeud noeudA, TypeLien type, int longueur) {
        this.noeudD = noeudD;
        this.noeudA = noeudA;
        this.type = type;
        this.longueur = longueur;
    }
    
    /**
     * Renvoie une chaine de caratères avec toute les infos du liens
     * @return Retourne une chaine de caratères avec toute les infos du liens
     */
    @Override
    public String toString() {
        return "nomD=" + noeudD.getNom() + ", nomA=" + noeudA.getNom() + ", type=" + type + ", taille=" + longueur;
    }

    /**
     * Renvoie le {@link Noeud} de départ
     * @return Retourne le {@link Noeud} de départ
     */
    public Noeud getNomD() {
        return noeudD;
    }
    
    /**
     * Renvoie le {@link Noeud} d'arrivée
     * @return Retourne le {@link Noeud} d'arrivée
     */
    public Noeud getNomA() {
        return noeudA;
    }

    /**
     * Renvoie le {@link TypeLien type} du lien
     * @return Retourne le {@link TypeLien type} du lien
     */
    public TypeLien getType() {
        return type;
    }

    /**
     * Renvoie la longueur du lien
     * @return Retourne la longueur du lien
     */
    public int getLongueur() {
        return longueur;
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
