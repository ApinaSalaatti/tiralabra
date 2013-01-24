/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.algoritmit;

import java.util.PriorityQueue;
import java.util.ArrayList;

/**
 * A*-algoritmin toteuttava luokka.
 * 
 * @author merioksa
 */
public class Astar {
    /**
     * Vielä läpi käymättömät solmut minimikeossa.
     * TODO: toteuta omalla tietorakenteella.
     */
    private PriorityQueue<Solmu> kasittelematta;
    /**
     * Jo käsitellyt solmut tavallisessa linkitetyssä listassa.
     * TODO: toteuta omalla tietorakenteella.
     */
    private ArrayList<Solmu> kasitelty;
    
    public Astar() {
        kasittelematta = new PriorityQueue<Solmu>();
        kasitelty = new ArrayList<Solmu>();
    }
    
    /**
     * Suorittaa algoritmin annetulla kartalla, kulkien annetusta lähtösolmusta annettuun maalisolmuun.
     * 
     * @param kartta kartta jolla reittia etsitään
     * @param alku solmu josta algoritmi lähtee reittiä etsimään
     * @param maali tavoitteena oleva solmu
     */
    public void aja(char[][] kartta, Solmu alku, Solmu maali) {
        
    }
}
