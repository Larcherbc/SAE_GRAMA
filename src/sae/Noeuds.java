/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

import java.util.ArrayList;

/**
 *
 * @author jules
 */
public class Noeuds extends ArrayList<Noeud>{
    
    public Noeud getNoeud(String name){
        Noeud noeud = null;
        for(Noeud obj :this){
            if(obj.getNom().equals(name)){
                noeud = obj;
            }
        }
        return noeud;
    }
    
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
    
    public int afficherRestaurent(){
        int compteur = 0;
        for(Noeud obj : this){
            if(obj.getType().equals("R")){
                System.out.println(obj);
                compteur++;
            }
        }
        return compteur;
    }
    
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
    
    public void afficherNoeuds(){
        for(Noeud obj : this){
            System.out.println(" - " + obj);
        }
    }
    
    public void afficherNombre(){
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
                case "resto":
                    nbResto++;
                    break;
            }
        }
        System.out.println("nombre de Noeuds :"+nbNoeuds);
        System.out.println("nombre de localités :"+nbLocalite);
        System.out.println("nombre de lieu de loisir :"+nbLoisir);
        System.out.println("nombre de restaurant :"+nbResto);
    }
    
}
