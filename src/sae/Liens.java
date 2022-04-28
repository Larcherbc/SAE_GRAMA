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
public class Liens extends ArrayList<Lien>{
    
    public void afficherAutoroute(){
        for(Lien obj : this){
            if(obj.getType().equals("A")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherNationale(){
        for(Lien obj : this){
            if(obj.getType().equals("N")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherDepartementale(){
        for(Lien obj : this){
            if(obj.getType().equals("D")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherLiens(){
        for(Lien obj : this){
            System.out.println(" - " + obj);
        }
    }
    
    public Lien getLien(Noeud depart, Noeud arrive){
        Lien recherche = null;
        for(Lien obj : this){
            if(obj.getNomA().equals(arrive) && obj.getNomD().equals(depart)){
                recherche = obj;
            }else if(obj.getNomD().equals(arrive) && obj.getNomA().equals(depart)){
                recherche = obj;
            }
        }
        return recherche;
    }
    
    public void afficherNombre(){
        int nbAuto=0;
        int nbNatio=0;
        int nbDep=0;
        int nbLiens = 0;
        for(Lien obj : this){
          nbLiens++;
            switch (obj.getType()){
                case "A":
                    nbAuto++;
                    break;
                case "N":
                    nbNatio++;
                    break;
                case "D":
                    nbDep++;
                    break;
            }  
        }
        System.out.println("nombre de liens :"+nbLiens);
        System.out.println("nombre d'autoroutes :"+nbAuto);
        System.out.println("nombre de nationale :"+nbNatio);
        System.out.println("nombre de départementales :"+nbDep);
    }
    
}
