/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sae;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import static sae.EcranPrincipal.main;
import static sae.SAE.main;

/**
 *
 * @author jules
 */
public class Graph extends JPanel{
    private Noeuds listeNoeuds;
    private Liens listeLiens;
    private final static int SIZE = 20;
    public Graph(Noeuds listeNoeuds,Liens listeLiens) {
        this.listeLiens = listeLiens;
        this.listeNoeuds = listeNoeuds;
    }
    
    
    
    public void paintComponent(Graphics g){
        g.setColor(Color.black);
        for(Lien obj : listeLiens){   
           g.drawLine(obj.getNomA().getCoord().x, obj.getNomA().getCoord().y, obj.getNomD().getCoord().x, obj.getNomD().getCoord().y);  
        }
        g.setColor(Color.red);
        for(Noeud obj : listeNoeuds){
            if(obj.getType().equals("R")){
                g.setColor(Color.blue);
            }
            else if(obj.getType().equals("V")){
                g.setColor(Color.red);
            }
            else if(obj.getType().equals("L")){
                g.setColor(Color.yellow);
            }
            g.fillOval(obj.getCoord().x - SIZE/2, obj.getCoord().y - SIZE/2, SIZE, SIZE);
            g.drawString(obj.getNom(), obj.getCoord().x, obj.getCoord().y + SIZE + 10);
            
        }
    }
    
}
