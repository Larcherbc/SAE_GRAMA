/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 * @author p2102071
 */
public class Main {
    private static final Noeuds listeNoeuds = new Noeuds();
    private static final Liens listeLiens = new Liens();
    EcranPrincipal fenetre;
    
    public Main(EcranPrincipal fenetre){
        this.fenetre = fenetre;
    }
    
    
    public Noeuds getListeNoeud(){
        return listeNoeuds;
    }
    public Liens getListeLiens(){
        return listeLiens;
    }
    
     /**
     * permet de charger le graphe en mémoire
     */
    public void chargeGraph() {
        Noeud noeudD;
        Noeud noeudA;
        try {
            String fileName = "GRAMA.txt";
            Scanner scan = new Scanner(new File(fileName));//on récupère le fichier
            while (scan.hasNextLine()) {//si la ligne existe
                String line = scan.nextLine();//on prend la ligne
                line = line.substring(0, line.length() - 2);//on enlève les ;; a la fin
                String noeud = line.substring(0, line.indexOf(":")); // on récupère le noeud au début de la ligne grace au :
                line = line.substring(line.indexOf(":") + 1); // on récupère le reste de la ligne sans le :
                noeudD = creationNoeud(noeud); // on créer le noeud
                String[] tabLiens = line.split(";"); //on split pour séparer chaque lien
                for (String lienLigne : tabLiens) {
                    String[] lienSplit = lienLigne.split("::");//split entre noeud et caratéristiques lien
                    noeudA = creationNoeud(lienSplit[1]); // on créer le noeud
                    creationLien(lienSplit[0], noeudD, noeudA); // on créer le lien
                }
            }
            fenetre.setSaveText("Le graph a bien été chargé en mémoire!!!");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SAE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * permet de créer un noeud si il n'existe pas déjà
     * @param line
     * @return 
     */
    public Noeud creationNoeud(String line) {
        String[] tabNoeud = line.split(","); // on split le début de la ligne pour créer un nv noeud
        Noeud nvNoeud = new Noeud(tabNoeud[1], tabNoeud[0]); // on le créer
        if (!listeNoeuds.contains(nvNoeud)) {//si il n'existe pas dans notre liste
            listeNoeuds.add(nvNoeud);// on l'ajoute
        }
        return nvNoeud;
    }
    
    /**
     * permet de créer un lien si il n'existe pas déjà
     * @param line
     * @param noeudD
     * @param noeudA 
     */
    public void creationLien(String line, Noeud noeudD, Noeud noeudA) {
        String[] tabLien = line.split(",");//on split les deux caractéristique
        int longueur = Integer.parseInt(tabLien[1]);// on convertit en int la longeur
        Lien nvLien = new Lien(noeudD, noeudA, tabLien[0], longueur);//on créer le nouveau lien
        if (!listeLiens.contains(nvLien)) {//si le lien n'existe pas dans notre liste
            listeLiens.add(nvLien);//on l'ajoute
        }
    }

    public void afficherNombre() {
        listeNoeuds.afficherNombre();
        listeLiens.afficherNombre();
    }
    
    /**
     * 
     * @param obj
     * @return retourne une liste de noeuds qui sont les voisins direct
     */
    public Noeuds afficheVoisinsDirect(Noeud noeud) {
        Noeud obj = listeNoeuds.getNoeud(fenetre.getInput());
        Noeuds liste = new Noeuds();
        for (Lien lien : listeLiens) {//on parcourt tout les liens
            if (lien.getNomD().equals(obj)) { //si le noeud de départ est le meme
                System.out.println(lien.getNomA());// on affiche le noeud d'arrivé
                liste.add(lien.getNomA());
            } else if (lien.getNomA().equals(obj)) {//si le noeud d'arrivé est le meme
                System.out.println(lien.getNomD());//on affiche celui de départ
                liste.add(lien.getNomD());
                fenetre.setTextArea(lien.getNomD().getNom());
            }
        }
        return liste;
    }
    
    /**
     * permet de savoir si 2 noeuds sont situé a une 2 distance
     * @param depart
     * @param arrive 
     */
    public void afficheDeuxDistance(Noeud depart, Noeud arrive) {
        System.out.println(depart);
        System.out.println(arrive);
        Lien lien1;
        Lien lien2;
        ArrayList<Noeud> voisinDirect = afficheVoisinsDirect(depart);
        for (Noeud noeud : voisinDirect) {
            ArrayList<Noeud> voisin2 = afficheVoisinsDirect(noeud);
            if (noeud.equals(arrive)) {
                System.out.println("les deux noeud sont relié directement");
                //on peut rajouter un break si on veux arreter la recherche ici
            }
            for (Noeud noeud2 : voisin2) {
                if (noeud2.equals(arrive)) {
                    lien1 = listeLiens.getLien(depart, noeud);
                    lien2 = listeLiens.getLien(noeud, arrive);
                    int distance = lien1.getLongueur() + lien2.getLongueur();
                    System.out.println("les 2 noeuds sont rélié et sont séparé de " + distance + " km en passant par " + noeud);
                }
            }
        }
    }
    
    /**
     * compare l'ouverture de 2 villes
     * @param noeud1
     * @param noeud2 
     */
    public void comparaisonNoeud(Noeud noeud1, Noeud noeud2) {
        System.out.println(noeud1);// affichage noeud de depart
        System.out.println(noeud2);
        if (!noeud1.getType().equals("V") || !noeud2.getType().equals("V")) {//si un des noeuds n'est pas une ville
            System.out.println("un des deux noeuds n'est pas une ville");
        } else {
            int nbVille1;
            int nbVille2;
            int nbResto1;
            int nbResto2;
            int nbLoisir1;
            int nbLoisir2;

            Noeuds listeOuverture1 = ouvertureNoeud(noeud1);// on récupère une liste de nooeuds qui sont a une 2 distance
            nbVille1 = listeOuverture1.afficherLocalite(); // on récupère le noombre de ville
            nbResto1 = listeOuverture1.afficherRestaurent();
            nbLoisir1 = listeOuverture1.afficherLoisir();

            Noeuds listeOuverture2 = ouvertureNoeud(noeud2);
            nbVille2 = listeOuverture2.afficherLocalite();
            nbResto2 = listeOuverture2.afficherRestaurent();
            nbLoisir2 = listeOuverture2.afficherLoisir();

            if (nbVille1 > nbVille2) {// on compare
                System.out.println(noeud1 + " est plus ouverte que " + noeud2);
            }else if(nbVille1 < nbVille2){
                System.out.println(noeud2 + " est plus ouverte que " + noeud1);
            }else{
                System.out.println("les deux villes sont autant ouverte");
            }
            // faut juste ajoouter les autres
        }
    }

    
    /**
     * 
     * @param noeud 
     * @return liste de Noeud a 2 distance du noeud de départ
     */
    public Noeuds ouvertureNoeud(Noeud noeud) {
        Noeuds listeVoisinDeuxD = new Noeuds();// on créé une liste de noeuds

        Noeuds voisinDirect = afficheVoisinsDirect(noeud);// on créé une liste de noeud de tout les voisins directs
        for (Noeud voisin : voisinDirect) {// on la parcourt
            ArrayList<Noeud> voisin2 = afficheVoisinsDirect(voisin); // on créé une liste de noeuds de tout les voisins a  2 distance
            for (Noeud noeud2 : voisin2) { // on la parcourt
                if (!listeVoisinDeuxD.contains(noeud2) && !noeud2.equals(noeud)) {// si la liste ne contient pas déjà le noeud et si ce n'est pas la ville de départ
                    listeVoisinDeuxD.add(noeud2);// on l'ajoute
                }
            }
        }
        return listeVoisinDeuxD;// on renvoit la liste des voisins a 2 distance
    }
}


