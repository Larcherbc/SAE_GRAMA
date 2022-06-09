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
 *
 * @author jules
 */
public class Noeud {

    private String Nom;
    private String type;
    private Point coord;

    public Noeud(String Nom, String type) {
        this.Nom = Nom;
        this.type = type;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void setCoord(int x, int y) {
        this.coord = new Point(getRandomNumberInRange(30, x-30), getRandomNumberInRange(30, y-30));
    }

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

    public Point getCoord() {
        return coord;
    }

    public String getNom() {
        return Nom;
    }

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
