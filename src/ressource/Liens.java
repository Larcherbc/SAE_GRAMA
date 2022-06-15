/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ressource;

import java.util.ArrayList;
import sae.Lien;
import sae.Noeud;

/**
 *Cette classe est une {@link ArrayList} de {@link Lien}. Elle permet d'effectuer différente action sur les liens qu'elle contient
 * @author jules Rabec
 */
public class Liens extends ArrayList<Lien>{
    
    /**
     * permet de créer une arrayList de lien
     */
    public Liens(){
        super();
    }
    
    /**
     * Renvoie un {@link String} qui contient toute les infos de tout les noeuds
     * @return Retourne un {@link String} qui contient toute les infos de tout les liens
     */
    public String afficherLiens(){
        String buffer="";
        for(Lien obj : this){
            buffer += obj.toString() +"\n\n";
        }
        return buffer;
    }
    
    /**
     * Renvoie un {@link Lien} contenu dans la liste qui a comme point de départ et point d'arrivée les {@link Noeud} donnée en paramètre, null sinon
     * @param depart Correspond au noeud de départ du lien chercher
     * @param arrive Correspond au noeud d'arrivée du lien chercher
     * @return Renvoie un {@link Lien} qui a comme point de départ et point d'arrivée les {@link Noeud} donnée en paramètre, null sinon
     */
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
    
    /**
     * Renvoie un {@link String} qui contient le nombre de chaque {@link TypeLien type} de lien contenue dans l'arrayList
     * @return Retourne un {@link String} qui contient le nombre de chaque {@link TypeLien type} de lien dans l'arrayList
     */
    public String afficherNombre(){
        String buffer ="";
        int nbAuto=0;
        int nbNatio=0;
        int nbDep=0;
        int nbLiens = 0;
        for(Lien obj : this){
          nbLiens++;
            switch (obj.getType()){
                case AUTOROUTE:
                    nbAuto++;
                    break;
                case NATIONALE:
                    nbNatio++;
                    break;
                case DEPARTEMENTALE:
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
    
    
    /**
     * Permet d'ajouter a l'arrayList les {@link TypeLien#AUTOROUTE autoroutes} contenu dans une arrayList de lien passée en paramètre
     * @param liste Correspond a une arrayList de lien a laquelle on veut copier les liens qui sont des {@link TypeLien#AUTOROUTE autoroutes}
     */
    public void addAuto(Liens liste){
        for(Lien obj : liste){
            if(obj.getType().equals(TypeLien.AUTOROUTE)){
                this.add(obj);
            }
        }
    }
    
    /**
     * Permet d'ajouter a l'arrayList les {@link TypeLien#NATIONALE nationales} contenu dans une arrayList de lien passée en paramètre
     * @param liste Correspond a une arrayList de lien a laquelle on veut copier les liens qui sont des {@link TypeLien#NATIONALE nationale}
     */
    public void addNatio(Liens liste){
        for(Lien obj : liste){
            if(obj.getType().equals(TypeLien.NATIONALE)){
                this.add(obj);
            }
        }
    }
    
    /**
     * Permet d'ajouter a l'arrayList les {@link TypeLien#DEPARTEMENTALE départementales} contenu dans une arrayList de lien passée en paramètre
     * @param liste Correspond a une arrayList de lien a laquelle on veut copier les liens qui sont des {@link TypeLien#DEPARTEMENTALE départementales}
     */
    public void addDepart(Liens liste){
        for(Lien obj : liste){
            if(obj.getType().equals(TypeLien.DEPARTEMENTALE)){
                this.add(obj);
            }
        }
    }
    
}
