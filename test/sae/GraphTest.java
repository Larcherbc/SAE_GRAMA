/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sae;

import org.junit.Test;
import static org.junit.Assert.*;

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
        Noeud noeud = new Noeud("Teuf-Teuf-Club","L");
        Noeuds expResult = new Noeuds(new Noeud("Lyon", "V"));
        Noeuds result = instance.afficheVoisinsDirect(noeud);
        System.out.println("result" +result);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of afficheDeuxDistance method, of class Graph.
     */
    @Test
    public void testAfficheDeuxDistance() {
        System.out.println("afficheDeuxDistance");
        Noeud depart = null;
        Noeud arrive = null;
        instance.afficheDeuxDistance(depart, arrive);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of comparaisonNoeud method, of class Graph.
     */
    @Test
    public void testComparaisonNoeud() {
        System.out.println("comparaisonNoeud");
        Noeud noeud1 = null;
        Noeud noeud2 = null;
        Graph instance = null;
        instance.comparaisonNoeud(noeud1, noeud2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ouvertureNoeud method, of class Graph.
     */
    @Test
    public void testOuvertureNoeud() {
        System.out.println("ouvertureNoeud");
        Noeud noeud = null;
        Graph instance = null;
        Noeuds expResult = null;
        Noeuds result = instance.ouvertureNoeud(noeud);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
