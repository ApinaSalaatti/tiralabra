/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka;

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
    
    public Logiikka() {
        kartta = new Kartta();
    }
    
    /**
     * Asetetaan käytössä oleva kartta.
     * 
     * @param k haluttu kartta char-taulukkona
     */
    public void asetaKartta(char[][] k) {
        kartta.asetaKartta(k);
    }
}
