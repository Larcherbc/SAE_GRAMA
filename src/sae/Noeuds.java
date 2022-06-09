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
    
    public void creationCoord(int x, int y){
        for(Noeud obj : this){
            obj.setCoord(x, y);
        }
        testCoord(x, y);

    }
    
    public void testCoord(int x, int y){
        for(Noeud obj : this){
            while(! isFarAwayFromAll(obj)){
                obj.setCoord(x, y);
            }
        }
    }
    
    public boolean isFarAwayFromAll(Noeud noeud){
        boolean statut = true;
        for(Noeud obj : this){
            if (!noeud.isFarEnough(obj))
                statut =false;
        }
        return statut;
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
    
    public String afficherNoeuds(){
        String buffer ="";
        for(Noeud obj : this){
            buffer+=obj.toString()+"\n";
        }
        return buffer;
    }
    
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
    
    public void addLocalite(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("V")){
                this.add(obj);
            }
        }
    }
    
    public void addResto(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("R")){
                this.add(obj);
            }
        }
    }
    
    public void addLoisir(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("L")){
                this.add(obj);
            }
        }
    }
    
}
