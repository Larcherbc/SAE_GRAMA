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
public class Noeud {
    
    private String Nom;
    private String type;

    public Noeud(String Nom, String type) {
        this.Nom = Nom;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Noeud{" + "Nom=" + Nom + ", type=" + type + '}';
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
