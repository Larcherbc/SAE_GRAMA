/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sae;

import java.util.ArrayList;

/**
 *
 * @author jules
 */
public class SAE {
    private int nbNoeuds;
    private int nbLiens;
    private static final ArrayList<Noeud> listeNoeuds = new ArrayList<Noeud>();
    private static final ArrayList<Lien> listeLiens = new ArrayList<Lien>() ;
    
    
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        remplir();
        afficherNombre();
    }
    
    public static void remplir(){
        Noeud lyon = new Noeud("Lyon","localite");
        Noeud vienne = new Noeud("Vienne","localite");
        Noeud annecy = new Noeud("Annecy","localite");
        listeNoeuds.add(lyon);
        listeNoeuds.add(vienne);
        listeNoeuds.add(annecy);
    }
    
    
    public static void afficherLocalite(){
        for(Noeud obj : listeNoeuds){
            if(obj.getType().equals("localite")){
                System.out.println(obj);
            }
        }
    }
    
    public static void afficherLoisir(){
        for(Noeud obj : listeNoeuds){
            if(obj.getType().equals("loisir")){
                System.out.println(obj);
            }
        }
    }
    
    public static void afficherResto(){
        for(Noeud obj : listeNoeuds){
            if(obj.getType().equals("resto")){
                System.out.println(obj);
            }
        }
    }
    
    public static void afficherAutoroutes(){
        for(Lien obj : listeLiens){
            if(obj.getType().equals("autoroute")){
                System.out.println(obj);
            }
        }
    }
    
    public static void afficherNationales(){
        for(Lien obj : listeLiens){
            if(obj.getType().equals("nationale")){
                System.out.println(obj);
            }
        }
    }
    
    public static void afficherDepartementales(){
        for(Lien obj : listeLiens){
            if(obj.getType().equals("departementale")){
                System.out.println(obj);
            }
        }
    }
    
    public static void afficherNoeuds(){
        for(Noeud obj : listeNoeuds){
            System.out.println(" - " + obj);
        }
    }
    
    public static void afficherLiens(){
        for(Lien obj : listeLiens){
            System.out.println(" - " + obj);
        }
    }
    
    public static void afficherNombre(){
        int nbLocalite=0;
        int nbLoisir=0;
        int nbResto=0;
        int nbAuto=0;
        int nbNatio=0;
        int nbDep=0;
        int nbNoeuds = 0;
        int nbLiens = 0;
        for(Noeud obj : listeNoeuds){
            nbNoeuds++;
            switch (obj.getType()){
                case "localite":
                    nbLocalite++;
                    break;
                case "loisir":
                    nbLoisir++;
                    break;
                case "resto":
                    nbResto++;
                    break;
            }
        }
        for(Lien obj : listeLiens){
            nbLiens++;
            switch (obj.getType()){
                case "autoroute":
                    nbAuto++;
                    break;
                case "nationale":
                    nbNatio++;
                    break;
                case "departementale":
                    nbDep++;
                    break;
            }
        }
        System.out.println("nombre de Noeuds :"+nbNoeuds);
        System.out.println("nombre de localités :"+nbLocalite);
        System.out.println("nombre de lieu de loisir :"+nbLoisir);
        System.out.println("nombre de restaurant :"+nbResto);
        System.out.println("nombre de liens :"+nbLiens);
        System.out.println("nombre d'autoroutes :"+nbAuto);
        System.out.println("nombre de départementales :"+nbDep);
    }
    
    public void afficheVoisinsDirect(Noeud obj){
        for(Lien lien: listeLiens){
            if(lien.getNomD().equals(obj.getNom())){
               
            }
        }
    }
}
