/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka;

/**
 * Luokka ohjelmassa kullakin hetkellä olevan karttadatan käsittelyä varten. Kartta on aina tallennettuna char-taulukkona.
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
     * Itse kartta char-taulukkona.
     */
    private char[][] kartta;
    
    public Kartta() {
        
    }
    
    public void asetaKartta(char[][] k) {
        kartta = k;
    }
}
