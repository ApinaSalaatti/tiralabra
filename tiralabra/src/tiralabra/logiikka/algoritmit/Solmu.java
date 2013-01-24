/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.algoritmit;

/**
 * Luokka joka kuvaa kartan yhtä ruutua koordinaateilla (x, y), toisin sanoen yhtä verkon solmua.
 * Lisäksi tallennetaan laskettu etäisyys lähtösolmuun ja A*-algoritmia varten tieto arvioidusta etäisyydestä maalisolmuun.
 * Yksinkertaisuuden vuoksi alkuun- ja maaliin-jäsenmuuttujat ovat julkisia, sillä niitä on tarkoitus muuttaa jatkuvasti.
 * 
 * @author merioksa
 */
public class Solmu implements Comparable {
    /**
     * Solmun x-koordinaatti.
     */
    private int x;
    /**
     * Solmun y-koordinaatti.
     */
    private int y;
    /**
     * Kustannus joka tähän solmuun liikkumisesta koituu. Toisin sanoen siis tähän solmuun johtavan kaaren pituus.
     */
    private int hinta;
    /**
     * Etäisyys lähtösolmuun.
     */
    public int alkuun;
    /**
     * Arvioitu etäisyys maalisolmuun.
     */
    public int maaliin;
    
    public Solmu(int X, int Y, int h) {
        x = X;
        y = Y;
        hinta = h;
        alkuun = 0;
        maaliin = 0;
    }
    
    /**
     * Getteri Solmun x-koordinaatille.
     * 
     * @return Solmun x-koordinaatti.
     */
    public int x() {
        return x;
    }
    /**
     * Getteri Solmun y-koordinaatille.
     * 
     * @return Solmun y-koordinaatti.
     */
    public int y() {
        return y;
    }
    
    /**
     * Getteri kustannukselle, joka Solmuun liikkumisesta koituu.
     * 
     * @return Solmuun liikkumisen hinta
     */
    public int hinta() {
        return hinta;
    }
    
    /**
     * Tulostaa Solmun koordinaatin
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    @Override
    public int compareTo(Object o) {
        Solmu s = (Solmu)o;
        
        return alkuun - s.alkuun;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Solmu) {
            Solmu s = (Solmu)o;
            if(this.x == s.x() && this.y == s.y()) {
                return true;
            }
        }
        
        return false;
    }
}
