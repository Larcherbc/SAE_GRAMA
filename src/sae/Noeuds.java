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
    
    public void afficherLocalite(){
        for(Noeud obj : this){
            if(obj.getType().equals("localite")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherRestaurent(){
        for(Noeud obj : this){
            if(obj.getType().equals("restaurent")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherLoisir(){
        for(Noeud obj : this){
            if(obj.getType().equals("loisir")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherNoeuds(){
        for(Noeud obj : this){
            System.out.println(" - " + obj);
        }
    }
}
