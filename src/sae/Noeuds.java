/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

import java.util.ArrayList;

/**
 * Cette classe est une {@link ArrayList} de {@link Noeud}. Elle permet d'effectuer différente action sur les noeuds qu'elle contient
 * @author Jules Rabec
 */
public class Noeuds extends ArrayList<Noeud>{
    
    
    /**
     * permet de créer une arrayList de {@link Noeud}
     */
    Noeuds(){
        super();
    }
    /**
     * permet de créer une arrayList de {@link Noeud} avec un noeud de base
     */
    Noeuds(Noeud noeud){
        super();
        this.add(noeud);
    }
    
    /**
     * Renvoie le {@link Noeud} correspondant au nom passé en paramètre, null s'il n'exitste pas
     * @param name Correspond au nom du noeud qu'on cherche
     * @return retourne le Noeud chercher
     */
    public Noeud getNoeud(String name){
        Noeud noeud = null;
        for(Noeud obj :this){
            if(obj.getNom().equals(name)){
                noeud = obj;
            }
        }
        return noeud;
    }
    
    /**
     * Appel la methode {@link Noeud#setCoord(int, int) setCoord} pour chaque noeud contenu dans l'arrayList puis appel la methode {@link #testCoord(int, int) TestCoord}
     * @param x correspond a la largeur max a laquelle le Noeud peut apparaitre
     * @param y correspond a la hauteur max a laquelle le Noeud peut apparaitre
     */
    public void creationCoord(int x, int y){
        for(Noeud obj : this){
            obj.setCoord(x, y);
        }
        testCoord(x, y);

    }
    
    /**
     * appel la methode {@link #isFarAwayFromAll(sae.Noeud)} pour chaque noeud contenu dans l'arrayList
     * @param x correspond a la largeur max a laquelle le Noeud peut apparaitre
     * @param y correspond a la hauteur max a laquelle le Noeud peut apparaitre
     */
    public void testCoord(int x, int y){
        for(Noeud obj : this){
            /*for (int i = 0; i < 100000; i++) {
                obj.setCoord(x, y);
            }*/
            while(!isFarAwayFromAll(obj)){
                obj.setCoord(x, y);
            }
        }
    }
    
    /**
     * Permet de vérifier si le {@link Noeud} passé en paramètre n'est pas trop proche de tout les autres {@link Noeud noeuds} contenu dans {@link Noeuds l'arrayList de noeuds}
     * @param noeud Correspond au {@link Noeud} auquelle on va comparer tout les autres
     * @return Retourne true si le noeud passé en paramètre est assez loin de tout les autres, false sinon
     */
    public boolean isFarAwayFromAll(Noeud noeud){
        boolean statut = true;
        for(Noeud obj : this){
            if (!noeud.isFarEnough(obj))
                statut =false;
        }
        return statut;
    }
    
    /**
     * Renvoie le nombre de ville contenu dans {@link Noeuds l'arrayList de noeuds}
     * @return Retourne le nombre de ville contenu dans {@link Noeuds l'arrayList de noeuds}
     */
    public int afficherLocalite(){
        int compteur = 0;
        for(Noeud obj : this){
            if(obj.getType().equals("V")){
                System.out.println(obj);
                compteur++;
            }
        }
        return compteur;
    }
    
    /**
     * Renvoie le nombre de restaurant contenu dans {@link Noeuds l'arrayList de noeuds}
     * @return Retourne le nombre de restaurant contenu dans {@link Noeuds l'arrayList de noeuds}
     */
    public int afficherRestaurant(){
        int compteur = 0;
        for(Noeud obj : this){
            if(obj.getType().equals("R")){
                System.out.println(obj);
                compteur++;
            }
        }
        return compteur;
    }
    
    /**
     * Renvoie le nombre de lieu de loisir contenu dans {@link Noeuds l'arrayList de noeuds}
     * @return Retourne le nombre de lieu de loisir contenu dans {@link Noeuds l'arrayList de noeuds}
     */
    public int afficherLoisir(){
        int compteur = 0;
        for(Noeud obj : this){
            if(obj.getType().equals("L")){
                System.out.println(obj);
                compteur++;
            }
        }
        return compteur;
    }
    
    /**
     * Renvoie {@link String une chaine de texte} qui contient tout les {@link Noeud noeuds}
     * @return Retourne {@link String une chaine de texte} qui contient tout les noeuds
     */
    public String afficherNoeuds(){
        String buffer ="";
        for(Noeud obj : this){
            buffer+=obj.toString()+"\n";
        }
        return buffer;
    }
    
    /**
     * Renvoie {@link String une chaine de texte} qui contient le nombre de type de chaque {@link Noeud noeud}
     * @return Retourne {@link String une chaine de texte} qui contient le nombre de type de {@link Noeud noeud}
     */
    public String afficherNombre(){
        String buffer="";
        int nbLocalite=0;
        int nbLoisir=0;
        int nbResto=0;
        int nbNoeuds = 0;
        for(Noeud obj : this){
            nbNoeuds++;
            switch (obj.getType()){
                case "V":
                    nbLocalite++;
                    break;
                case "L":
                    nbLoisir++;
                    break;
                case "R":
                    nbResto++;
                    break;
            }
        }
        buffer+= "nombre de Noeuds :"+nbNoeuds + "\n";
        buffer += "nombre de localités :"+nbLocalite+ "\n";
        buffer += "nombre de lieu de loisir :"+nbLoisir+ "\n";
        buffer +="nombre de restaurant :"+nbResto + "\n";
        return buffer;
    }
    
    /**
     * Permet d'ajouter a l'arrayList les villes contenu dans une arrayList de noeud passés en paramètre
     * @param liste Correspond a une arrayList de noeud a laquelle on veut copier les noeuds qui sont des villes
     */
    public void addLocalite(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("V")){
                this.add(obj);
            }
        }
    }
    
    /**
     * Permet d'ajouter a l'arrayList les restaurant contenu dans une arrayList de noeud passés en paramètre
     * @param liste Correspond a une arrayList de noeud a laquelle on veut copier les noeuds qui sont des restaurants
     */
    public void addResto(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("R")){
                this.add(obj);
            }
        }
    }
    
    /**
     * Permet d'ajouter a l'arrayList les lieux de loisir contenu dans une arrayList de noeud passés en paramètre
     * @param liste Correspond a une arrayList de noeud a laquelle on veut copier les noeuds qui sont des lieux de loisir
     */
    public void addLoisir(Noeuds liste){
        for(Noeud obj : liste){
            if(obj.getType().equals("L")){
                this.add(obj);
            }
        }
    }
    
}
