/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sae;

import ressource.Noeuds;
import org.junit.Test;
import static org.junit.Assert.*;
import ressource.TypeNoeud;

/**
 *
 * @author jules
 */
public class GraphTest {
    
    Graph instance = new Graph(new EcranPrincipal());



    /**
     * Test of chargeGraph method, of class Graph.
     */
    @Test
    public void testChargeGraph() {
        System.out.println("chargeGraph");
        instance.chargeGraph();
        assertTrue(instance.getListeNoeudSelection()!=null);
    }

    /**
     * Test of afficheVoisinsDirect method, of class Graph.
     */
    @Test
    public void testAfficheVoisinsDirect() {
        System.out.println("afficheVoisinsDirect");
        instance.chargeGraph();
        Noeud noeud = new Noeud("Teuf-Teuf-Club",TypeNoeud.LOISIR);
        Noeuds expResult = new Noeuds(new Noeud("Lyon", TypeNoeud.VILLE));
        Noeuds result = instance.afficheVoisinsDirect(noeud);
        System.out.println("result" +result);
        
        assertEquals(expResult, result);
    }

    
}
