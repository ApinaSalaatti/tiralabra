/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.algoritmit;

import java.util.ArrayList;
import tiralabra.logiikka.tietorakenteet.*;
import tiralabra.logiikka.Kartta;

/**
 * Dijkstran algoritmin toteuttava luokka.
 * 
 * @author merioksa
 */
public class Dijkstra extends Algoritmi {
    /**
     * Vielä läpi käymättömät solmut minimikeossa.
     */
    private Minimikeko<Solmu> kasittelematta;
    
    public Dijkstra() {
        kasittelematta = new Minimikeko<Solmu>();
    }
    
    /**
     * Getteri taululle, joka tallettaa tiedon mistä Solmusta kuhunkin Solmuun on saavuttu
     * 
     * @return algoritmin löytämän reitin säilyttävä Solmu[]-taulukko, joka on null jos algoa ei ole kertaakaan ajettu
     */
    public Solmu[] polku() {
        return polku;
    }
    
    @Override
    public void aja(Solmu[][] kartta, Solmu alku, Solmu maali) {
        this.kartta = kartta;
        
        aloitusSolmu = alku;
        maaliSolmu = maali;
        
        polku = new Solmu[kartta.length * kartta[0].length];
        
        long alkuAika = System.currentTimeMillis();
        
        ISS(kartta, alku);
        lisaaSolmut(kartta);
      
        while(!kasittelematta.tyhja()) {
            Solmu s = kasittelematta.poll();
            loysaaKaikki(kartta, s);
        }
        
        kulunutAika = System.currentTimeMillis() - alkuAika;

        //tulokset();
    }
    
    /**
     * Lisää annetun Solmu[][]-taulun kaikki Solmut käsittelemättömien olmujen joukkoon.
     */
    public void lisaaSolmut(Solmu[][] kartta) {
        for(int i = 0; i < kartta.length; i++) {
            for(int j = 0; j < kartta[0].length; j++) {
                kasittelematta.lisaa(kartta[i][j]);
            }
        }
    }
    
    /**
     * Initialize single source -metodi, toisin sanoen metodi joka asettaa kaikkien kartan Solmujen etäisyydeksi "äärettömän" (eli tosi ison).
     * Lopuksi aloitussolmun etäisyydeksi asetetaan 0.
     */
    private void ISS(Solmu[][] kartta, Solmu alku) {
        for(int y = 0; y < kartta.length; y++) {
            for(int x = 0; x < kartta[0].length; x++) {
                kartta[y][x].alkuun = Integer.MAX_VALUE - 1000000; // ei MAX_VALUE, koska tällöin siihen plussaaminen heittäisi sen negatiiviseksi
                polku[kartta[y][x].indeksi()] = null;
            }
        }
        
        // asetetaan alkusolmun etäisyydeksi 0
        kartta[alku.y()][alku.x()].alkuun = 0;
    }
    
    /**
     * Löysätään kaikki annetun solmun naapurisolmut.
     * 
     * @param kartta kartta jota ollaan tutkimassa
     * @param s Solmu jonka naapurisolmuja ollaan löysäämässä
     */
    public void loysaaKaikki(Solmu[][] kartta, Solmu s) {
        if(s.x() > 0) {
            loysaa(kasittelematta, kartta[s.y()][s.x()], kartta[s.y()][s.x() - 1]); // vasemmalle
        }
        if(s.x() < kartta[0].length - 1) {
            loysaa(kasittelematta, kartta[s.y()][s.x()], kartta[s.y()][s.x() + 1]); // oikealle
        }
        if(s.y() > 0) {
            loysaa(kasittelematta, kartta[s.y()][s.x()], kartta[s.y() - 1][s.x()]); // ylös
        }
        if(s.y() < kartta.length - 1) {
            loysaa(kasittelematta, kartta[s.y()][s.x()], kartta[s.y() + 1][s.x()]); // alas
        }
    }
    
    /**
     * Metodi joka "löysää" (relax) etäisyyden annettuun Solmuun v, mikäli etäisyys siihen on sen nykyistä etäisyyttä lyhyempi annetun Solmun u kautta.
     * Löysäämisen jälkeen vähennetään Solmun avainta minimikeossa.
     * 
     * @param solmut keko josta solmuja poimitaan
     * @param u Solmu jonka kautta saavutaan
     * @param v Solmu jota löysätään
     */
    private void loysaa(Minimikeko<Solmu> solmut, Solmu u, Solmu v) {
        if(v.alkuun > u.alkuun + v.hinta()) {
            v.alkuun = u.alkuun + v.hinta();
            polku[v.indeksi()] = u;
            solmut.jarjestaYlos(v);
        }
    }
    
    @Override
    public void tulokset() {
        System.out.println("DIJKSTRA");
        super.tulokset();
    }
}
