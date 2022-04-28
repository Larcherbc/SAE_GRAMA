/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sae;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jules
 */
public class SAE {
    private int nbNoeuds;
    private int nbLiens;
    private static final Noeuds listeNoeuds = new Noeuds();
    private static final Liens listeLiens = new Liens() ;
    
    private static Noeud lyon = new Noeud("Lyon","localite");
    private static Noeud vienne = new Noeud("Vienne","localite");
    private static Noeud annecy = new Noeud("Annecy","localite");
    private static Noeud resto = new Noeud("resto","restaurent");
    private static Lien lien1 = new Lien(lyon,annecy,"A",100);
    private static Lien lien2 = new Lien(lyon,vienne,"A",20);
    private static Lien lien3 = new Lien(annecy,resto,"A",20);
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        remplir();
        listeNoeuds.afficherLocalite();
        comparaisonNoeud(lyon,annecy);
        csv();
        
    }
    
    public static void remplir(){
        
        listeNoeuds.add(lyon);
        listeNoeuds.add(vienne);
        listeNoeuds.add(annecy);
        listeNoeuds.add(resto);
        listeLiens.add(lien1);
        listeLiens.add(lien2);
        listeLiens.add(lien3);
    }
    
    public static void csv(){
        try {
            String fileName = "GRAMA.txt";
            Scanner scan = new Scanner(new File(fileName));
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SAE.class.getName()).log(Level.SEVERE, null, ex);
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
                    if(lien2.getNomA().equals(noeudCentre) && !lien2.getNomD().equals(depart) || lien2.getNomD().equals(noeudCentre) && !lien2.getNomA().equals(depart)){
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
    
    public static void comparaisonNoeud(Noeud noeud1, Noeud noeud2){
        int nbVille1;
        int nbVille2;
        int nbResto1;
        int nbResto2;
        int nbLoisir1;
        int nbLoisir2;
        ArrayList<Integer> listeOuverture = ouvertureNoeud(noeud1);
        nbVille1 =listeOuverture.get(0);
        nbResto1 =listeOuverture.get(1);
        nbLoisir1 =listeOuverture.get(2);
        System.out.println(listeOuverture);
        listeOuverture = ouvertureNoeud(noeud2);
        nbVille2 =listeOuverture.get(0);
        nbResto2 =listeOuverture.get(1);
        nbLoisir2 =listeOuverture.get(2);
        System.out.println(listeOuverture);
        
    }
    
    public static ArrayList ouvertureNoeud(Noeud noeud){
        int nbVille=0;
        int nbResto=0;
        int nbLoisir=0;
        ArrayList listeOuverture = new ArrayList();
        for (Lien lien1 : listeLiens){
            if(lien1.getNomA().equals(noeud) || lien1.getNomD().equals(noeud)){
                Noeud noeudCentre;
                if(lien1.getNomA().equals(noeud)){
                    noeudCentre = lien1.getNomD();
                }else{
                    noeudCentre = lien1.getNomA();
                }
                for (Lien lien2 : listeLiens){
                   if(lien2.getNomA().equals(noeudCentre) && !lien2.getNomD().equals(noeud) || lien2.getNomD().equals(noeudCentre) && !lien2.getNomA().equals(noeud)){
                       Noeud noeudFinal;
                        if(lien2.getNomA().equals(noeudCentre)){
                            noeudFinal = lien2.getNomD();
                        }else{
                            noeudFinal = lien2.getNomA();
                        }
                        switch (noeudFinal.getType()){
                            case "localite": nbVille++;
                            break;
                            case "restaurent":nbResto++;
                            break;
                            case"loisir":nbLoisir++;
                            break;
                        }
                   } 
                }
            }
        }
        listeOuverture.add(nbVille);
        listeOuverture.add(nbResto);
        listeOuverture.add(nbLoisir);
        return listeOuverture;
    }
}
