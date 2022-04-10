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
            if(obj.getType().equals("autoroute")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherNationale(){
        for(Lien obj : this){
            if(obj.getType().equals("nationale")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherDepartementale(){
        for(Lien obj : this){
            if(obj.getType().equals("departemental")){
                System.out.println(obj);
            }
        }
    }
    
    public void afficherLiens(){
        for(Lien obj : this){
            System.out.println(" - " + obj);
        }
    }
    
}
