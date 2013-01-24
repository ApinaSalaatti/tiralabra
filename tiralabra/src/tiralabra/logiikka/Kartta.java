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
