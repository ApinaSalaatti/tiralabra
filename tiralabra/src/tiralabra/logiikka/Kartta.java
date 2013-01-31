/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka;

import tiralabra.logiikka.algoritmit.Solmu;
/**
 * Luokka ohjelmassa kullakin hetkellä olevan karttadatan käsittelyä varten. Kartta luetaan char[][]-taulusta ja tallennetaan Solmu olioita sisältävään taulukkoon.
 * 
 * @author merioksa
 */
public class Kartta {
    /**
     * Globaali vakio merkille joka esittää kartalla seinää.
     */
    public static final char SEINA = '#';
    /**
     * Globaali vakio merkille joka esittää kartalla lattiaa.
     */
    public static final char LATTIA = '.';
    /**
     * Kartta Solmu-olioiden taulukkona algoritmeja varten.
     */
    private Solmu[][] kartta;
    /**
     * Kartta merkkeinä tulostamista varten.
     */
    private char[][] karttaCh;
    /**
     * Viimeisin asetettu lähtö-koordinaatti (asetetaan uuden kartan yhteydessä koordinaatteihin (0, 0).
     */
    private Solmu alku;
    /**
     * Viimeisin asetettu maali-koordinaatti (asetetaan uuden kartan yhteydessä koordinaatteihin (kartan leveys, kartan korkeus).
     */
    private Solmu maali;
    
    public Kartta() {
        kartta = null;
        karttaCh = null;
    }
    
    /**
     * Getteri kartan Solmut sisältävälle taulukolle.
     * 
     * @return kulloinkin käytössä oleva kartta
     */
    public Solmu[][] kartta() {
        return kartta;
    }
    
    /**
     * Metodi jonka avulla voidaan syöttää kartta char-taulukkona. Taulukko muutetaan Solmu-olioita sisältäväksi taulukoksi.
     * 
     * @param k lähteenä toimiva char[][]-taulu
     */
    public void asetaKartta(char[][] k) {
        karttaCh = k;
        kartta = new Solmu[k.length][k[0].length];
        
        luoKartta(k);
        
        alku = kartta[0][0];
        maali = kartta[kartta.length-1][kartta[0].length-1];
    }
    
    /**
     * Muuttaa parametrina annetun char[][] taulukon Solmu[][]-taulukoksi
     * 
     * @param k lähteenä toimiva char[][]-taulukko
     */
    public void luoKartta(char[][] k) {
        int indx = 0;
        for(int y = 0; y < k.length; y++) {
            for(int x = 0; x < k[0].length; x++) {
                if(k[y][x] == Kartta.LATTIA) {
                    kartta[y][x] = new Solmu(x, y, 1, indx); // lattialla liikkumisen hinta on aina 1
                    indx++;
                }
                else if(k[y][x] == Kartta.SEINA) {
                    kartta[y][x] = new Solmu(x, y, 10, indx); // seinään "kaivautumisen" hinta on 10
                    indx++;
                }
            }
        }
    }
    
    /**
     * Palauttaa tämänhetkisen lähtösolmun.
     * 
     * @return lähtöpaikkana toimiva solmu
     */
    public Solmu alku() {
        return alku;
    }
    /**
     * Asettaa aloitussolmuksi parametreinä annetuissa koordinaateissa olevan solmun.
     * 
     * @param x haluttu x-koordinaatti
     * @param y haluttu y-koordinaatti
     */
    public void alku(int x, int y) {
        if(kartta == null) {
            System.out.println("Karttaa ei ole asetettu!");
        }
        else if(x < 0 || x > kartta[0].length || y < 0 || y > kartta.length) {
            System.out.println("Virheelliset koordinaatit!");
        }
        else {
            alku = kartta[x][y];
        }
    }
    
    /**
     * Palauttaa tämänhetkisen maalisolmun.
     * 
     * @return maalina toimiva solmu
     */
    public Solmu maali() {
        return maali;
    }
    /**
     * Asettaa maalisolmuksi parametreinä annetuissa koordinaateissa olevan solmun.
     * 
     * @param x haluttu x-koordinaatti
     * @param y haluttu y-koordinaatti
     */
    public void maali(int x, int y) {
        if(kartta == null) {
            System.out.println("Karttaa ei ole asetettu!");
        }
        else if(x < 0 || x > kartta[0].length || y < 0 || y > kartta.length) {
            System.out.println("Virheelliset koordinaatit!");
        }
        else {
            maali = kartta[x][y];
        }
    }
    
    /**
     * Tulostaa tällä hetkellä käytössä olevan kartan, tai virheen jos karttaa ei ole asetettu.
     */
    public void tulosta() {
        if(karttaCh != null) {
            for(int y = 0; y < karttaCh.length; y++) {
                for(int x = 0; x < karttaCh[0].length; x++) {
                    System.out.print(karttaCh[y][x]);
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Karttaa ei ole asetettu!");
        }
    }
}
