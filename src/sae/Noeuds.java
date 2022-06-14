/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * Cette classe est une arrayList de {@link Noeud}. Elle permet d'effectuer différente action sur les noeuds qu'elle contient
 * @author Jules Rabec
 */
public class Noeuds extends ArrayList<Noeud>{
    
    /**
     * Renvoie le noeud correspondant au nom passer en paramètre, null s'il n'exitste pas
     * @param name Correspond au nom du noeud qu'on cherche
     * @return retourne le Noeud chercher
     */
    public Noeud getNoeud(String name){
        Noeud noeud = null;
        for(Noeud obj :this){
            if(obj.getNom().equals(name)){
                noeud = obj;
            }
        }
        return noeud;
    }
    
    /**
     * Appel la methode {@link Noeud#setCoord(int, int) setCoord} pour chaque noeud contenu dans l'arrayList puis appel la methode {@link #testCoord(int, int) TestCoord}
     * @param x correspond a la largeur max a laquelle le Noeud peut apparaitre
     * @param y correspond a la hauteur max a laquelle le Noeud peut apparaitre
     */
    public void creationCoord(int x, int y){
        for(Noeud obj : this){
            obj.setCoord(x, y);
        }
        testCoord(x, y);

    }
    
    /**
     * appel la methode {@link #isFarAwayFromAll(sae.Noeud)} pour chaque noeud contenu dans l'arrayList
     * @param x correspond a la largeur max a laquelle le Noeud peut apparaitre
     * @param y correspond a la hauteur max a laquelle le Noeud peut apparaitre
     */
    public void testCoord(int x, int y){
        for(Noeud obj : this){
            while(! isFarAwayFromAll(obj)){
                obj.setCoord(x, y);
            }
        }
    }
    
    /**
     * Permet de vérifier si le noeud passer en paramètre n'est pas trop proche de tout les autres noeuds contenu dans l'arrayList
     * @param noeud Correspond au noeud auquelle on va comparer tout les autres
     * @return Retourne true si le noeud passé en paramètre est assez loin de tout les autres, false sinon
     */
    public boolean isFarAwayFromAll(Noeud noeud){
        boolean statut = true;
        for(Noeud obj : this){
            if (!noeud.isFarEnough(obj))
                statut =false;
        }
        return statut;
    }
    
    /**
     * Renvoie le nombre de ville contenu dans l'arrayList
     * @return Retourne le nombre de ville contenu dans l'arrayList
     */
    public int afficherLocalite(){
        int compteur = 0;
        for(Noeud obj : this){
            if(obj.getType().equals("V")){
                System.out.println(obj);
                compteur++;
            }
        }
        return compteur;
    }
    
    /**
     * Renvoie le nombre de restaurant contenu dans l'arrayList
     * @return Retourne le nombre de restaurant contenu dans l'arrayList
     */
    public int afficherRestaurant(){
        int compteur = 0;
        for(Noeud obj : this){
            if(obj.getType().equals("R")){
                System.out.println(obj);
                compteur++;
            }
        }
        return compteur;
    }
    
    /**
     * Renvoie le nombre de lieu de loisir contenu dans l'arrayList
     * @return Retourne le nombre de lieu de loisir contenu dans l'arrayList
     */
    public int afficherLoisir(){
        int compteur = 0;
        for(Noeud obj : this){
            if(obj.getType().equals("L")){
                System.out.println(obj);
                compteur++;
            }
        }
        return compteur;
    }
    
    /**
     * Renvoie une chaine de texte qui contient tout les noeuds
     * @return Retourne une chaine de texte qui contient tout les noeuds
     */
    public String afficherNoeuds(){
        String buffer ="";
        for(Noeud obj : this){
            buffer+=obj.toString()+"\n";
        }
        return buffer;
    }
    
    /**
     * Renvoie une chaine de texte qui contient le nombre de type de noeud
     * @return Retourne une chaine de texte qui contient le nombre de type de noeud
     */
    public String afficherNombre(){
        String buffer="";
        int nbLocalite=0;
        int nbLoisir=0;
        int nbResto=0;
        int nbNoeuds = 0;
        for(Noeud obj : this){
            nbNoeuds++;
            switch (obj.getType()){
                case "V":
                    nbLocalite++;
                    break;
                case "L":
                    nbLoisir++;
                    break;
                case "R":
                    nbResto++;
                    break;
            }
        }
        buffer+= "nombre de Noeuds :"+nbNoeuds + "\n";
        buffer += "nombre de localités :"+nbLocalite+ "\n";
        buffer += "nombre de lieu de loisir :"+nbLoisir+ "\n";
        buffer +="nombre de restaurant :"+nbResto + "\n";
        return buffer;
    }
    
    /**
     * Permet d'ajouter a l'arrayList les villes contenu dans une arrayList passé en paramètre
     * @param liste Correspond a une arrayList a laquelle on veut copier les villes
     */
    public void addLocalite(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("V")){
                this.add(obj);
            }
        }
    }
    
    /**
     * Permet d'ajouter a l'arrayList les restaurant contenu dans une arrayList passé en paramètre
     * @param liste Correspond a une arrayList a laquelle on veut copier les restaurant
     */
    public void addResto(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("R")){
                this.add(obj);
            }
        }
    }
    
    /**
     * Permet d'ajouter a l'arrayList les villes contenu dans une arrayList passé en paramètre
     * @param liste Correspond a une arrayList a laquelle on veut copier les lieu de loisir
     */
    public void addLoisir(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("L")){
                this.add(obj);
            }
        }
    }
    
}
