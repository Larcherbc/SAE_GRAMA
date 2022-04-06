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
    
    private static Noeud lyon = new Noeud("Lyon","localite");
    private static Noeud vienne = new Noeud("Vienne","localite");
    private static Noeud annecy = new Noeud("Annecy","localite");
    private static Lien lien1 = new Lien(lyon,annecy,"A",100);
    private static Lien lien2 = new Lien(lyon,vienne,"A",20);
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        remplir();
        afficheDeuxDistance(lyon, annecy);
    }
    
    public static void remplir(){
        
        listeNoeuds.add(lyon);
        listeNoeuds.add(vienne);
        listeNoeuds.add(annecy);
        listeLiens.add(lien1);
        listeLiens.add(lien2);
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
    
    public static void afficheVoisinsDirect(Noeud obj){
        for(Lien lien: listeLiens){
            if(lien.getNomD().equals(obj) || lien.getNomA().equals(obj)){
               System.out.println(lien.getNomA());
            }
        }
    }
    
    public static void afficheInfoLien(Lien lien){
        System.out.println("Ce lien relie le " + lien.getNomD() + "et le " + lien.getNomD());
    }
    
    public static void afficheDeuxDistance(Noeud depart, Noeud arrive){
        boolean trouve = false;
        int distance = -1;
        for(Lien lien: listeLiens){
            Noeud lienD = lien.getNomD();
            Noeud lienA = lien.getNomA();
            if(lienA.equals(depart) || lienD.equals(depart)){
                Noeud noeudCentre;
                if(lienA.equals(depart)){
                    noeudCentre = lienD;
                }else{
                    noeudCentre = lienA;
                }
                for(Lien lien2:listeLiens){
                    Noeud lien2D = lien2.getNomD();
                    Noeud lien2A = lien2.getNomA();
                    if(lien2.getNomA().equals(noeudCentre) && !lien2.equals(lien) || lien2.getNomD().equals(noeudCentre) && !lien2.equals(lien)){
                        if(lien2A.equals(arrive) || lien2D.equals(arrive)){
                            trouve = true;
                            distance = lien.getLongueur()+lien2.getLongueur();
                            break;
                        }
                    }
                }
            }
        }
        if (trouve){
            System.out.println("les 2 noeuds sont rélié et son séparé de " + distance+ " km");
        }else{
            System.out.println("lex deux villes ne sont pas connecté a une 2-distance");
        }
        
    }
}
