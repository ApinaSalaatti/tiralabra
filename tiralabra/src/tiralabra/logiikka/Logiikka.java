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
    /**
     * Bellman-Fordin algoritmi
     */
    private BellmanFord bellmanFord;
    /**
     * A*-algoritmi
     */
    private Astar astar;
    
    public Logiikka() {
        kartta = new Kartta();
        dijkstra = new Dijkstra();
        bellmanFord = new BellmanFord();
        astar = new Astar();
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
     * Asetetaan Solmu josta algoritmit lähtevät reittiä hakemaan.
     * 
     * @param x haluttu x-koordinaatti
     * @param y haluttu y-koordinaatti
     */
    public void asetaAlku(int x, int y) {
        kartta.alku(x, y);
    }
    /**
     * Asetetaan Solmu johon algoritmit etsivät reittiä.
     * 
     * @param x haluttu x-koordinaatti
     * @param y haluttu y-koordinaatti
     */
    public void asetaMaali(int x, int y) {
        kartta.maali(x, y);
    }
    
    /**
     * Ajaa parametrina annetun algoritmin tällä hetkellä käytössä olevalla kartalla.
     * 
     * @param algo haluttu algoritmi, parametri "Kaikki" suorittaa kaikki algoritmit.
     */
    public void ajaAlgoritmi(String algo) {
        Solmu[][] k = kartta.kartta();
        Solmu alku = kartta.alku();
        Solmu maali = kartta.maali();
        
        if(k != null) {
            if(algo.equals("Dijkstra")) {
                dijkstra.aja(k, alku, maali);
            }
            else if(algo.equals("Bellman-Ford")) {
                bellmanFord.aja(k, alku, maali);
            }
            else if(algo.equals("Astar")) {
                astar.aja(k, alku, maali);
            }
            else if(algo.equals("Kaikki")) {
                dijkstra.aja(k, alku, maali);
                bellmanFord.aja(k, alku, maali);
                astar.aja(k, alku, maali);
            }
        }
        else {
            System.out.println("Karttaa ei ole asetettu!");
        }
    }
    
    /**
     * Tulostaa viimeisimpien ajojen tulokset.
     */
    public void tulokset() {
        dijkstra.tulokset();
        bellmanFord.tulokset();
        astar.tulokset();
    }
}
