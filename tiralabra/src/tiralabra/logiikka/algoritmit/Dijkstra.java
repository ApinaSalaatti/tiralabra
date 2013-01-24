/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.algoritmit;

import java.util.ArrayList;
import java.util.PriorityQueue;
import tiralabra.logiikka.Kartta;

/**
 * Dijkstran algoritmin toteuttava luokka.
 * 
 * @author merioksa
 */
public class Dijkstra {
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
    /**
     * Viimeisimpään suoritukseen kulunut aika.
     */
    private long kulunutAika;
    /**
     * Edellisessä ajossa käytetty aloitussolmu (tulosten tulostamista varten)
     */
    private Solmu aloitusSolmu;
    /**
     * Edellisessä ajossa käytetty maalisolmu (tulosten tulostamista varten)
     */
    private Solmu maaliSolmu;
    /**
     * Taulukko, jonka kussakin indeksissä on talletettuna se Solmu josta kyseisen indeksin omaavaan Solmuun on saavuttu.
     */
    private Solmu[] polku;
    
    public Dijkstra() {
        kasittelematta = new PriorityQueue<Solmu>();
        kasitelty = new ArrayList<Solmu>();
        polku = null;
    }
    
    /**
     * Getteri taululle, joka tallettaa tiedon mistä Solmusta kuhunkin Solmuun on saavuttu
     * 
     * @return algoritmin löytämän reitin säilyttävä Solmu[]-taulukko, joka on null jos algoa ei ole kertaakaan ajettu
     */
    public Solmu[] polku() {
        return polku;
    }
    
    /**
     * Suorittaa algoritmin annetulla kartalla, lähtien annetusta lähtösolmusta.
     * 
     * @param kartta kartta jolla reittia etsitään
     * @param alku solmu josta algoritmi lähtee reittiä etsimään
     * @param maali tavoitteena oleva solmu
     */
    public void aja(Solmu[][] kartta, Solmu alku, Solmu maali) {
        aloitusSolmu = alku;
        maaliSolmu = maali;
        
        polku = new Solmu[kartta.length * kartta[0].length];
        
        long alkuAika = System.currentTimeMillis();
        ISS(kartta, alku);
        
        for(int i = 0; i < kartta.length; i++) {
            for(int j = 0; j < kartta[0].length; j++) {
                kasittelematta.add(kartta[i][j]);
            }
        }
        
        while(!kasittelematta.isEmpty()) {
            Solmu s = kasittelematta.poll();
            kasitelty.add(s);
            
            // löysätään kaikki naapurisolmut
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
        
        kulunutAika = System.currentTimeMillis() - alkuAika;
        
        tulokset();
    }
    
    /**
     * Initialize single source -metodi, toisin sanoen metodi joka asettaa kaikkien kartan Solmujen etäisyydeksi "äärettömän" (eli tosi ison).
     * Lopuksi aloitussolmun etäisyydeksi asetetaan 0.
     */
    private void ISS(Solmu[][] kartta, Solmu alku) {
        for(int y = 0; y < kartta.length; y++) {
            for(int x = 0; x < kartta[0].length; x++) {
                kartta[y][x].alkuun = Integer.MAX_VALUE - 100000; // ei MAX_VALUE, koska tällöin siihen plussaaminen heittäisi sen negatiiviseksi
                polku[kartta[y][x].indeksi()] = null;
            }
        }
        
        // asetetaan alkusolmun etäisyydeksi 0
        kartta[alku.y()][alku.x()].alkuun = 0;
    }
    
    /**
     * Metodi joka "löysää" (relax) etäisyyden annettuun Solmuun v, mikäli etäisyys siihen on sen nykyistä etäisyyttä lyhyempi annetun Solmun u kautta.
     * Löysäämisen jälkeen vähennetään Solmun avainta minimikeossa.
     * 
     * @param solmut keko josta solmuja poimitaan
     * @param u Solmu jonka kautta saavutaan
     * @param v Solmu jota löysätään
     */
    private void loysaa(PriorityQueue<Solmu> solmut, Solmu u, Solmu v) {
        // TODO: pitäisikö myös kulmittain voida liikkua, niin että hintaan lisätään kerroin 1,4?
        if(v.alkuun > u.alkuun + v.hinta()) {
            v.alkuun = u.alkuun + v.hinta();
            polku[v.indeksi()] = u;
        }
        
        // kikkailua, näin jono pysyy varmasti järjestyksessä. Muuttunee suuntaan tai toiseen kun saan omat tietorakenteet kuntoon.
        if(solmut.remove(v)) {
            solmut.add(v);
        }
    }
    
    /**
     * Tulostaa viimeisimmän ajon tulokset.
     */
    public void tulokset() {
        System.out.println("DIJKSTRA");
        System.out.println("Aikaa kului: " + kulunutAika + "ms");
        System.out.println("Lyhin reitti solmusta " + aloitusSolmu + " solmuun " + maaliSolmu + ":");
        
        Solmu nyt = polku[maaliSolmu.indeksi()];
        
        System.out.println(maaliSolmu);
        while(nyt != null) {
            System.out.println(nyt);
            nyt = polku[nyt.indeksi()];
        }
    }
}
