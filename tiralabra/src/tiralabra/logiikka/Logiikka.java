/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka;

import tiralabra.logiikka.algoritmit.*;
/**
 * Ohjelman loogiset osa-alueet (käytössä oleva kartta ja algoritmit) yhteen solmiva luokka.
 * 
 * @author merioksa
 */
public class Logiikka {
    /**
     * Käytössä olevan karttadatan sisältävä luokka.
     */
    private Kartta kartta;
    /**
     * Dijkstran algoritmi.
     */
    private Dijkstra dijkstra;
    
    public Logiikka() {
        kartta = new Kartta();
        dijkstra = new Dijkstra();
    }
    
    /**
     * Asetetaan käytössä oleva kartta.
     * 
     * @param k haluttu kartta char-taulukkona
     */
    public void asetaKartta(char[][] k) {
        kartta.asetaKartta(k);
    }
    
    /**
     * Tulostaa kullakin hetkellä käytössä olevan kartan.
     */
    public void tulostaKartta() {
        kartta.tulosta();
    }
    
    /**
     * Ajaa parametrina annetun algoritmin tällä hetkellä käytössä olevalla kartalla.
     * 
     * @param algo haluttu algoritmi, parametri "Kaikki" suorittaa kaikki algoritmit.
     */
    public void ajaAlgoritmi(String algo) {
        Solmu[][] k = kartta.kartta();
        
        if(k != null) {
            if(algo.equals("Dijkstra")) {
                dijkstra.aja(k, k[0][0], k[1][1]);
            }
            else if(algo.equals("Bellman-Ford")) {

            }
            else if(algo.equals("Astar")) {

            }
            else if(algo.equals("Kaikki")) {

            }
        }
        else {
            System.out.println("Karttaa ei ole asetettu!");
        }
    }
}
