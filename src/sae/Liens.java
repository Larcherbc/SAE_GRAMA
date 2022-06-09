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
    
    public String afficherLiens(){
        String buffer="";
        for(Lien obj : this){
            buffer += obj.toString() +"\n";
        }
        return buffer;
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
    
    public String afficherNombre(){
        String buffer ="";
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
        buffer +="nombre de liens :"+nbLiens +"\n";
        buffer +="nombre d'autoroutes :"+nbAuto+"\n";
        buffer +="nombre de nationale :"+nbNatio+"\n";
        buffer += "nombre de départementales :"+nbDep+"\n";
        return buffer;
    }
    
    public void addAuto(Liens liste){
        for(Lien obj : liste){
            if(obj.getType().equals("A")){
                this.add(obj);
            }
        }
    }
    
    public void addNatio(Liens liste){
        for(Lien obj : liste){
            if(obj.getType().equals("N")){
                this.add(obj);
            }
        }
    }
    
    public void addDepart(Liens liste){
        for(Lien obj : liste){
            if(obj.getType().equals("D")){
                this.add(obj);
            }
        }
    }
    
}
