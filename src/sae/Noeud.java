/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

import java.awt.Point;
import java.util.Objects;
import java.util.Random;
import javax.swing.JPanel;

/**
 * Cette classe permet de définir ce qu'est un noeud. Un noeud possède un nom, un type et est associé a un point pour pouvoir être placer dans une fenetre
 * @author Jules Rabec
 */
public class Noeud {

//ATTRIBUTS
    /**
     * Correspond au nom du noeud
     */
    private String Nom;
    /**
     * Correspond au type du noeud
     */
    private String type;
    /**
     * Correspond au point où se situe le noeud
     */
    private Point coord;

    /**
     * Permet de créer un Noeud avec un nom et un type
     * @param Nom Correspond au nom du noeud
     * @param type Correspond au type du noeud
     */
    public Noeud(String Nom, String type) {
        this.Nom = Nom;
        this.type = type;
    }
    
    /**
     * Renvoie un nombre aléatoire entre min et max données en paramètres
     * @param min Correspond à la valeur minimal du nombre aléatoire
     * @param max Correspond à la valeur maximal du nombre aléatoire
     * @return Retourne un nombre aléatoire entre min et max
     */
    public static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Assigne un nouveau point au noeud. Les coordoonées du point sont aléatoire grace a la méthode {@link #getRandomNumberInRange(int, int) } mais inférieur a une limite en x et en y
     * @param x Correspond à la valeur maximal en largeur pour le point
     * @param y Correspond à la valeur maximal en hauteur pour le point
     */
    public void setCoord(int x, int y) {
        this.coord = new Point(getRandomNumberInRange(30, x-30), getRandomNumberInRange(30, y-30));
    }

    /**
     * Permet de vérifier qu'un noeud passer en paramètre est assez loin du noeud courrant
     * @param noeud Correspond au noeud auquel on veut comparer le noeud actuel
     * @return Renvoie false si le noeud n'est pas assez loin, true sinon
     */
    public boolean isFarEnough(Noeud noeud) {
        if (noeud.coord != null && !this.equals(noeud)) {
            if (this.coord.distance(noeud.coord) > 100) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nom=" + Nom + ", type=" + type + ", coord: " + coord.x + " " + coord.y;
    }
    
    
    /**
     * Renvoie le point correspondant au noeud
     * @return Retourne le point correspondant au noeud
     */
    public Point getCoord() {
        return coord;
    }

    /**
     * Renvoie le nom du noeud
     * @return Retourne le nom du noeud
     */
    public String getNom() {
        return Nom;
    }

    /**
     * Renvoie le type du noeud
     * @return Retourne le type du noeud
     */
    public String getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Noeud other = (Noeud) obj;
        return Objects.equals(this.Nom, other.Nom);
    }

}
