/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sae;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Jules Rabec
 */
public class Graph extends JPanel {

    private static Noeuds listeNoeuds;
    private static Noeuds listeNoeudsSelection;
    private static Noeuds listeNoeudsHighlight;
    private static Liens listeLiens;
    private static Liens listeLiensSelection;
    private static Liens listeLiensHighlight;
    private static Noeuds currentNode;
    private static Lien currentLien;
    EcranPrincipal fenetre;
    private final static int SIZE = 20;
    private final static int DEFAULTWIDTH = 900;
    private final static int DEFAULTHEIGHT = 500;

    public Graph(EcranPrincipal fenetre) {
        this.fenetre = fenetre;
        this.listeNoeuds = new Noeuds();
        this.listeNoeudsSelection = new Noeuds();
        this.listeNoeudsHighlight = new Noeuds();
        this.listeLiens = new Liens();
        this.listeLiensSelection = new Liens();
        this.listeLiensHighlight = new Liens();
        this.currentNode = new Noeuds();
        this.currentLien = null;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        for (Lien obj : listeLiensSelection) {
            switch (obj.getType()){
                case "A":
                    g.setColor(Color.PINK);
                    break;
                case "N":
                    g.setColor(Color.magenta);
                    break;
                case "D":
                    g.setColor(Color.BLACK);
                    break;
            }
            g.drawLine(obj.getNomA().getCoord().x, obj.getNomA().getCoord().y, obj.getNomD().getCoord().x, obj.getNomD().getCoord().y);
        }
        g.setColor(Color.yellow);
        for (Noeud obj : listeNoeudsHighlight) {
            g.fillOval(obj.getCoord().x - (SIZE + 10) / 2, obj.getCoord().y + 6, SIZE + 10, SIZE / 2);
        }
        for (Lien obj : listeLiensHighlight) {
            g.drawLine(obj.getNomA().getCoord().x, obj.getNomA().getCoord().y, obj.getNomD().getCoord().x, obj.getNomD().getCoord().y);
        }

        for (Noeud obj : listeNoeudsSelection) {
            switch (obj.getType()) {
                case "R":
                    g.setColor(Color.blue);
                    break;
                case "V":
                    g.setColor(Color.red);
                    break;
                case "L":
                    g.setColor(Color.green);
                    break;
                default:
                    break;
            }
            g.fillOval(obj.getCoord().x - SIZE / 2, obj.getCoord().y - SIZE / 2, SIZE, SIZE);
            if (listeNoeudsHighlight.contains(obj)) {
                g.setColor(Color.yellow);
            }
            g.drawString(obj.getNom(), obj.getCoord().x - obj.getNom().length() / 2 * 5, obj.getCoord().y + SIZE + 10);

        }
        g.setColor(Color.orange);
        if (currentNode.size() >= 1) {
            for(Noeud obj : currentNode){
                g.fillOval(obj.getCoord().x - SIZE / 2, obj.getCoord().y - SIZE / 2, SIZE, SIZE);
            g.drawString(obj.getNom(), obj.getCoord().x - obj.getNom().length() / 2 * 5, obj.getCoord().y + SIZE + 10);
            }
        }
        if (currentLien != null) {
            g.drawLine(currentLien.getNomA().getCoord().x, currentLien.getNomA().getCoord().y, currentLien.getNomD().getCoord().x, currentLien.getNomD().getCoord().y);
        }

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
            fenetre.setJLabelGraph("Le graphe a bien été chargé");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (this.getWidth() == 0) {
            listeNoeuds.creationCoord(DEFAULTWIDTH, DEFAULTHEIGHT);
        } else {
            listeNoeuds.creationCoord(this.getWidth(), this.getHeight());
        }
        defaultList();
        fenetre.setJTextAreaData("NOEUDS :\n" + listeNoeudsSelection.afficherNoeuds() + "\n LIENS : \n" + listeLiensSelection.afficherLiens());
        fenetre.setJTextAreaInfo(listeNoeudsSelection.afficherNombre() + "\n" + listeLiensSelection.afficherNombre());
    }

    /**
     * permet de créer un noeud si il n'existe pas déjà
     *
     * @param line
     * @return
     */
    public Noeud creationNoeud(String line) {
        String[] tabNoeud = line.split(","); // on split le début de la ligne pour créer un nv noeud
        Noeud nvNoeud = new Noeud(tabNoeud[1], tabNoeud[0]); // on le créer
        if (!listeNoeuds.contains(nvNoeud)) {//si il n'existe pas dans notre liste
            listeNoeuds.add(nvNoeud);// on l'ajoute
        } else {
            nvNoeud = listeNoeuds.getNoeud(tabNoeud[1]);
        }
        return nvNoeud;
    }

    /**
     * permet de créer un lien si il n'existe pas déjà
     *
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

    public void emptyCurrentListNoeuds() {
        Graph.listeNoeudsSelection.clear();
    }

    public void emptyCurrentListLiens() {
        Graph.listeLiensSelection.clear();
    }

    public void defaultList() {
        Graph.listeNoeudsSelection = (Noeuds) listeNoeuds.clone();
        Graph.listeLiensSelection = (Liens) listeLiens.clone();
    }

    public void getCurrentLien(Liens listeDepart) {
        Liens buffer = (Liens) listeLiensSelection.clone();
        emptyCurrentListLiens();
        for (Lien obj : buffer) {
            if (listeNoeudsSelection.contains(obj.getNomA()) && listeNoeudsSelection.contains(obj.getNomD())) {
                listeLiensSelection.add(obj);
            }
        }
    }

    public void getCurrentLien() {
        emptyCurrentListLiens();
        for (Lien obj : listeLiens) {
            if (listeNoeudsSelection.contains(obj.getNomA()) && listeNoeudsSelection.contains(obj.getNomD())) {
                listeLiensSelection.add(obj);
            }
        }
    }

    public void setSelectedData(String obj, String obj2){
        listeNoeudsHighlight.clear();
        currentNode = new Noeuds();
        currentLien = null;
        Noeud noeud = listeNoeudsSelection.getNoeud(obj);
        currentNode.add(noeud);
        currentLien = null;
        Noeud noeud2 = listeNoeudsSelection.getNoeud(obj2);
        currentNode.add(noeud2);
        afficheDeuxDistance(noeud, noeud2);
        
    }
    
    public void setSelectedData(String obj) {
        listeNoeudsHighlight.clear();
        currentNode = new Noeuds();
        currentLien = null;
        if (obj == null) {
            
        } else {
            if (obj.contains("from")) {
                String buffer = obj.substring(obj.indexOf(": ") + 2, obj.indexOf(" to"));
                obj = obj.substring(obj.indexOf(" to"));
                String buffer2 = obj.substring(obj.indexOf(" : ") + 3);
                Lien lien = listeLiensSelection.getLien(listeNoeudsSelection.getNoeud(buffer), listeNoeudsSelection.getNoeud(buffer2));
                listeNoeudsHighlight.add(lien.getNomA());
                listeNoeudsHighlight.add(lien.getNomD());
                currentLien = lien;
            } else {
                Noeud noeud = listeNoeudsSelection.getNoeud(obj);
                currentNode.add(noeud);
                Noeuds test = afficheVoisinsDirect(noeud);

            }

        }
        updateListeLiensHighlight();
    }

    public void setSelectedData() {
        emptyCurrentListLiens();
        emptyCurrentListNoeuds();
        int test = fenetre.getSelectedData();
        if (test >= 32) {
            test -= 32;
            listeLiensSelection.addDepart(listeLiens);
        }
        if (test >= 16) {
            test -= 16;
            listeLiensSelection.addNatio(listeLiens);
        }
        if (test >= 8) {
            test -= 8;
            listeLiensSelection.addAuto(listeLiens);
        }
        if (test >= 4) {
            test -= 4;
            listeNoeudsSelection.addLoisir(listeNoeuds);
        }
        if (test >= 2) {
            test -= 2;
            listeNoeudsSelection.addResto(listeNoeuds);
        }
        if (test >= 1) {
            test -= 1;
            listeNoeudsSelection.addLocalite(listeNoeuds);
        }
        getCurrentLien(listeLiensSelection);
        fenetre.setJTextAreaData("NOEUDS :\n" + listeNoeudsSelection.afficherNoeuds() + "\n LIENS : \n" + listeLiensSelection.afficherLiens());
        fenetre.setJTextAreaInfo(listeNoeudsSelection.afficherNombre() + "\n" + listeLiensSelection.afficherNombre());
    }

    public Noeuds getListeNoeudSelection() {
        return listeNoeudsSelection;
    }

    public Liens getListeLiensSelection() {
        return listeLiensSelection;
    }

    public void updateListeLiensHighlight() {
        listeLiensHighlight.clear();
        for (Lien obj : listeLiensSelection) {
            if (currentNode.contains(obj.getNomA()) && listeNoeudsSelection.contains(obj.getNomD())) {
                listeLiensHighlight.add(obj);
            } else if (currentNode.contains(obj.getNomD()) && listeNoeudsSelection.contains(obj.getNomA())) {
                listeLiensHighlight.add(obj);
            }
        }
    }

    /**
     *
     * @param noeud
     * @param obj
     * @return retourne une liste de noeuds qui sont les voisins direct
     */
    public Noeuds afficheVoisinsDirect(Noeud noeud) {
        Noeuds liste = new Noeuds();
        for (Lien lien : listeLiens) {//on parcourt tout les liens
            if (lien.getNomD().equals(noeud)) { //si le noeud de départ est le meme
                //System.out.println(lien.getNomA());// on affiche le noeud d'arrivé
                liste.add(lien.getNomA());
                listeNoeudsHighlight.add(lien.getNomA());
                //listeNoeudsSelection.add(lien.getNomA());
            } else if (lien.getNomA().equals(noeud)) {//si le noeud d'arrivé est le meme
                //System.out.println(lien.getNomD());//on affiche celui de départ
                liste.add(lien.getNomD());
                //listeNoeudsSelection.add(lien.getNomD());
                listeNoeudsHighlight.add(lien.getNomD());
            }
        }
        updateListeLiensHighlight();
        return liste;
    }

    /**
     * permet de savoir si 2 noeuds sont situé a une 2 distance
     *
     * @param depart
     * @param arrive
     */
    public void afficheDeuxDistance(Noeud depart, Noeud arrive) {
        Lien lien1;
        Lien lien2;
        ArrayList<Noeud> voisinDirect = afficheVoisinsDirect(depart);
        for (Noeud noeud : voisinDirect) {
            ArrayList<Noeud> voisin2 = afficheVoisinsDirect(noeud);
            listeLiensHighlight.clear();
            listeNoeudsHighlight.clear();
            if (noeud.equals(arrive)) {
                fenetre.setDeuxDistanceTexte("les deux noeud sont relié directement");
                System.out.println(currentNode);
                listeLiensHighlight.add(listeLiensSelection.getLien(depart, arrive));
                return;
            }
            for (Noeud noeud2 : voisin2) {
                if (noeud2.equals(arrive)) {
                    lien1 = listeLiens.getLien(depart, noeud);
                    lien2 = listeLiens.getLien(noeud, arrive);
                    int distance = lien1.getLongueur() + lien2.getLongueur();
                    listeLiensHighlight.add(lien2);
                    listeLiensHighlight.add(lien1);
                    listeNoeudsHighlight.add(noeud);
                    fenetre.setDeuxDistanceTexte("les 2 noeuds sont rélié et sont séparé de " + distance + " km en passant par " + noeud.getNom());
                    return;
                }
            }
            
            
        }
    }

    /**
     * compare l'ouverture de 2 villes
     *
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
            } else if (nbVille1 < nbVille2) {
                System.out.println(noeud2 + " est plus ouverte que " + noeud1);
            } else {
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
