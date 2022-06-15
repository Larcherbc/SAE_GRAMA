/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sae;

import ressource.Noeuds;
import ressource.Liens;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ressource.TypeLien;
import ressource.TypeNoeud;

/**
 *Cette classe est la classe principale qui permet de créer le graphe et d'effectuer des actions dessus
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

    
    /**
     * Permet de créer un graph a partir d'une fenetre {@link JFrame} passé en paramètre
     * @param fenetre correspond a la fenetre lié au graphe qui permet d'interagir avec elle
     */
    public Graph(EcranPrincipal fenetre) {
        this.fenetre = fenetre;
        Graph.listeNoeuds = new Noeuds();
        Graph.listeNoeudsSelection = new Noeuds();
        Graph.listeNoeudsHighlight = new Noeuds();
        Graph.listeLiens = new Liens();
        Graph.listeLiensSelection = new Liens();
        Graph.listeLiensHighlight = new Liens();
        Graph.currentNode = new Noeuds();
        Graph.currentLien = null;
    }

    /**
     * Permet de dessiner le graphe. Cette méthode va utiliser les attributs de la classe {@link Graph} qui sont différentes {@link ArrayList} qui contiennent des noeuds ou des liens qui vont être peint différement selon les {@link ArrayList} auxquelles ils appartiennent
     * @param g correspond au peintre qui va dessiner le graphe
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        for (Lien obj : listeLiensSelection) {
            switch (obj.getType()){
                case AUTOROUTE:
                    g.setColor(new Color(170, 111, 57));
                    break;
                case NATIONALE:
                    g.setColor(Color.magenta);
                    break;
                case DEPARTEMENTALE:
                    g.setColor(Color.BLACK);
                    break;
            }
            g.drawLine(obj.getNomA().getCoord().x, obj.getNomA().getCoord().y, obj.getNomD().getCoord().x, obj.getNomD().getCoord().y);
        }
        g.setColor(Color.yellow);
        for (Noeud obj : currentNode) {
            g.fillOval(obj.getCoord().x - (SIZE + 10) / 2, obj.getCoord().y + 6, SIZE + 10, SIZE / 2);
        }
        for (Lien obj : listeLiensHighlight) {
            g.drawLine(obj.getNomA().getCoord().x, obj.getNomA().getCoord().y, obj.getNomD().getCoord().x, obj.getNomD().getCoord().y);
        }

        for (Noeud obj : listeNoeudsSelection) {
            switch (obj.getType()) {
                case RESTO:
                    g.setColor(Color.blue);
                    break;
                case VILLE:
                    g.setColor(Color.red);
                    break;
                case LOISIR:
                    g.setColor(new Color(74, 145, 48));
                    break;
                default:
                    break;
            }
            g.fillOval(obj.getCoord().x - SIZE / 2, obj.getCoord().y - SIZE / 2, SIZE, SIZE);
            g.drawString(obj.getNom(), obj.getCoord().x - obj.getNom().length() / 2 * 5, obj.getCoord().y + SIZE + 10);

        }
        g.setColor(Color.orange);
            for(Noeud obj : listeNoeudsHighlight){
                g.fillOval(obj.getCoord().x - SIZE / 2, obj.getCoord().y - SIZE / 2, SIZE, SIZE);
        }
        if (currentLien != null) {
            g.drawLine(currentLien.getNomA().getCoord().x, currentLien.getNomA().getCoord().y, currentLien.getNomD().getCoord().x, currentLien.getNomD().getCoord().y);
        }

    }

    /**
     * Permet de charger le graph en mémoire a partir d'un csv
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
     * permet de créer un {@link Noeud} si il n'existe pas déjà puis de le renvoyer ou de renvoyer le noeud existant qui correspond aux infos de la ligne
     *
     * @param line Correspond a une partie de ligne du fichier csv qui nous intéresse pour créer un noeud
     * @return Retourne le {@link Noeud} qui a été créer ou le {@link Noeud} existant qui correspond aux infos de la ligne
     */
    public Noeud creationNoeud(String line) {
        String[] tabNoeud = line.split(","); // on split le début de la ligne pour créer un nv noeud
        TypeNoeud type = null;
        switch (tabNoeud[0]) {
            case "V":
                type = TypeNoeud.VILLE;
                break;
            case "R":
                type = TypeNoeud.RESTO;
                break;
            case "L":
                type = TypeNoeud.LOISIR;
                break;
        }
        Noeud nvNoeud = new Noeud(tabNoeud[1], type); // on le créer
        if (!listeNoeuds.contains(nvNoeud)) {//si il n'existe pas dans notre liste
            listeNoeuds.add(nvNoeud);// on l'ajoute
        } else {
            nvNoeud = listeNoeuds.getNoeud(tabNoeud[1]);
        }
        return nvNoeud;
    }

    /**
     * permet de créer un lien si il n'existe pas déjà a partir des infos contenue dans la partie de ligne passé en paramètre et des noeuds de départ et d'arrivé
     *
     * @param line correspond a une partie de ligne du fichier csv qui nous intéresse pour créer un lien
     * @param noeudD correspond au noeud de départ du lien
     * @param noeudA correspond au noeud d'arrivé du lien
     */
    public void creationLien(String line, Noeud noeudD, Noeud noeudA) {
        String[] tabLien = line.split(",");//on split les deux caractéristique
        int longueur = Integer.parseInt(tabLien[1]);// on convertit en int la longeur
        TypeLien type = null;
        switch(tabLien[0]){
            case "A":
                type = TypeLien.AUTOROUTE;
                break;
            case "N":
                type = TypeLien.NATIONALE;
                break;
            case "D":
                type = TypeLien.DEPARTEMENTALE;
                break;
        }
        Lien nvLien = new Lien(noeudD, noeudA, type, longueur);//on créer le nouveau lien
        if (!listeLiens.contains(nvLien)) {//si le lien n'existe pas dans notre liste
            listeLiens.add(nvLien);//on l'ajoute
        }
    }

    /**
     * Permet de vider la liste de {@link Noeud} selectionnée
     */
    public void emptyCurrentListNoeuds() {
        Graph.listeNoeudsSelection.clear();
    }

    /**
     * Permet de vider la liste de {@link Lien} selectionnée
     */
    public void emptyCurrentListLiens() {
        Graph.listeLiensSelection.clear();
    }

    /**
     * Permet de copier les {@link Noeud} et {@link Lien} de base dans des arrayList qui nous donne les {@link Noeud} et {@link Lien} selectionnés
     */
    public void defaultList() {
        Graph.listeNoeudsSelection = (Noeuds) listeNoeuds.clone();
        Graph.listeLiensSelection = (Liens) listeLiens.clone();
    }

    /**
     * Permet de garder dans {@link #listeLiensSelection} uniquement les liens qui ont un {@link Noeud} de départ et un {@link Noeud} d'arrivé qui sont selectionnés
     */
    public void getCurrentLien() {
        Liens buffer = (Liens) listeLiensSelection.clone();
        emptyCurrentListLiens();
        for (Lien obj : buffer) {
            if (listeNoeudsSelection.contains(obj.getNomA()) && listeNoeudsSelection.contains(obj.getNomD())) {
                listeLiensSelection.add(obj);
            }
        }
    }

    /**
     * Permet de selectionner deux {@link Noeud noeuds} a partir d'infos contenu dans des {@link String chaines de caratères} donné en paramètre
     * @param string correspond aux infos du premier {@link Noeud}
     * @param string2 correspond aux infos du deuxième {@link Noeud}
     */
    public void setSelectedData(String string, String string2){
        listeNoeudsHighlight.clear();
        currentNode = new Noeuds();
        Noeud noeud = listeNoeudsSelection.getNoeud(string);
        currentNode.add(noeud);
        currentLien = null;
        Noeud noeud2 = listeNoeudsSelection.getNoeud(string2);
        currentNode.add(noeud2);
        comparaisonNoeud(noeud, noeud2);
        afficheDeuxDistance(noeud, noeud2);
    }
    
    /**
     * Permet de selectionner un noeud ou un lien
     * @param string correspond a une chaine de caratère qui contient des infos sur un noeud ou un lien
     */
    public void setSelectedData(String string) {
        listeNoeudsHighlight.clear();
        currentNode = new Noeuds();
        currentLien = null;
        if (string == null) {
            
        } else {
            if (string.contains("from")) {
                String buffer = string.substring(string.indexOf(": ") + 2, string.indexOf(" to"));
                string = string.substring(string.indexOf(" to"));
                String buffer2 = string.substring(string.indexOf(" : ") + 3);
                Lien lien = listeLiensSelection.getLien(listeNoeudsSelection.getNoeud(buffer), listeNoeudsSelection.getNoeud(buffer2));
                listeNoeudsHighlight.add(lien.getNomA());
                listeNoeudsHighlight.add(lien.getNomD());
                currentLien = lien;
            } else {
                Noeud noeud = listeNoeudsSelection.getNoeud(string);
                currentNode.add(noeud);
                Noeuds test = afficheVoisinsDirect(noeud);

            }

        }
        updateListeLiensHighlight();
    }

    /**
     * Permet de mettre a jour la liste des noeuds et liens selectionnés à partir des case a cocher selectionnés
     */
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
            listeNoeudsSelection.addLocalite(listeNoeuds);
        }
        getCurrentLien();
        fenetre.setJTextAreaData("NOEUDS :\n" + listeNoeudsSelection.afficherNoeuds() + "\n LIENS : \n" + listeLiensSelection.afficherLiens());
        fenetre.setJTextAreaInfo(listeNoeudsSelection.afficherNombre() + "\n" + listeLiensSelection.afficherNombre());
    }

    /**
     * Renvoie la liste de {@link Noeud} selectionné
     * @return Retourne la liste de {@link Noeud} selectionné
     */
    public Noeuds getListeNoeudSelection() {
        return listeNoeudsSelection;
    }

    /**
     * Renvoie la liste de {@link Lien} selectionné
     * @return Retourne la liste de {@link Lien} selectionné
     */
    public Liens getListeLiensSelection() {
        return listeLiensSelection;
    }

    /**
     * Permet de mettre a jour la liste des {@link Lien} a dessiner d'une couleur différente a partir du {@link Noeud} actuellement selectionné
     */
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
     * Renvoie une {@link Noeuds liste de noeud} qui correspond a tout les voisins direct du {@link Noeud} passé en paramètre
     * @param noeud Correspond au {@link Noeud} de départ des tests pour trouver ses voisins
     * @return retourne une {@link Noeuds liste de noeud} qui sont les voisins direct du {@link Noeud} de départ donnée en paramètre
     */
    public Noeuds afficheVoisinsDirect(Noeud noeud) {
        Noeuds liste = new Noeuds();
        for (Lien lien : listeLiensSelection) {//on parcourt tout les liens
            if (lien.getNomD().equals(noeud)) { //si le noeud de départ est le meme
                //System.out.println(lien.getNomA());// on affiche le noeud d'arrivé
                liste.add(lien.getNomA());
                listeNoeudsHighlight.add(lien.getNomA());
            } else if (lien.getNomA().equals(noeud)) {//si le noeud d'arrivé est le meme
                //System.out.println(lien.getNomD());//on affiche celui de départ
                liste.add(lien.getNomD());
                listeNoeudsHighlight.add(lien.getNomD());
            }
        }
        updateListeLiensHighlight();
        return liste;
    }

    /**
     * permet de savoir si deux {@link Noeud noeuds} passé en paramètre sont situé relié par un chemin constitué de deux {@link Lien liens}
     *
     * @param depart correspond au {@link Noeud} de départ du chemin potentiellement existant
     * @param arrive correspond au {@link Noeud} d'arrivé
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
                fenetre.setDeuxDistanceTexte("Les deux noeud sont relié directement");
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
                    fenetre.setDeuxDistanceTexte("Les deux noeuds sont rélié et sont séparé de " + distance + " km en passant par " + noeud.getNom());
                    return;
                }
            }
            
            
        }
        fenetre.setDeuxDistanceTexte("Les deux noeuds ne sont pas relié");
    }

    /**
     * Permet de comparer l'ouverture de 2 villes qui sont des {@link Noeud noeuds} cad laquelle des deux est rélié a un plus grand nombre d'autre {@link Noeud Noeuds}
     *
     * @param noeud1 correspond au premier {@link Noeud}  pour la comparaison
     * @param noeud2 correspond au deuxième {@link Noeud} pour la comparaison
     */
    public void comparaisonNoeud(Noeud noeud1, Noeud noeud2) {
        String buffer = "";
        if (!noeud1.getType().equals(TypeNoeud.VILLE) || !noeud2.getType().equals(TypeNoeud.VILLE)) {//si un des noeuds n'est pas une ville
            buffer = "un des deux noeuds n'est pas une ville";
        } else {
            int nbVille1;
            int nbVille2;
            int nbResto1;
            int nbResto2;
            int nbLoisir1;
            int nbLoisir2;

            Noeuds listeOuverture1 = ouvertureNoeud(noeud1);// on récupère une liste de nooeuds qui sont a une 2 distance
            nbVille1 = listeOuverture1.compteLocalite(); // on récupère le noombre de ville
            nbResto1 = listeOuverture1.compteRestaurant();
            nbLoisir1 = listeOuverture1.compteLoisir();

            Noeuds listeOuverture2 = ouvertureNoeud(noeud2);
            nbVille2 = listeOuverture2.compteLocalite();
            nbResto2 = listeOuverture2.compteRestaurant();
            nbLoisir2 = listeOuverture2.compteLoisir();

            if (nbVille1 > nbVille2) {// on compare
                buffer += noeud1.getNom() + " est plus ouverte que " + noeud2.getNom() + "\n";
            } else if (nbVille1 < nbVille2) {
                buffer += noeud2.getNom() + " est plus ouverte que " + noeud1.getNom() + "\n";
            } else {
                buffer += "les deux villes sont autant ouverte";
            }
            if (nbResto1 > nbResto2) {// on compare
                buffer += noeud1.getNom() + " est plus gastronomique que " + noeud2.getNom() + "\n";
            } else if (nbVille1 < nbVille2) {
                buffer += noeud2.getNom() + " est plus gastronomique que " + noeud1.getNom() + "\n";
            } else {
                buffer += "les deux villes sont autant gastronomique \n";
            }
            if (nbLoisir1 > nbLoisir2) {// on compare
                buffer += noeud1.getNom() + " est plus culturelle que " + noeud2.getNom();
            } else if (nbVille1 < nbVille2) {
                buffer += noeud2.getNom() + " est plus culturelle que " + noeud1.getNom();
            } else {
                buffer += "les deux villes sont autant culturelle";
            }
        }
        fenetre.setOuvertureTexte(buffer);
        listeNoeudsHighlight.clear();
        listeLiensHighlight.clear();
    }

    /**
     * Renvoie une {@link Noeuds arrayList de noeuds} qui contient tout les noeuds situé a une 2-distance du {@link Noeud} de départ donnée en paramètre
     * @param noeud correspond au {@link Noeud} de départ
     * @return une {@link Noeuds arrayList de noeuds} qui contient tout les noeuds situé a une 2-distance du {@link Noeud} de départ donnée en paramètre
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
