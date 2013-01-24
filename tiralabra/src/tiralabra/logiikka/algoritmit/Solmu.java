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
     * Uniikki indeksinumero, jonka avulla kukin solmu erotetaan esimerkiksi kuljettua polkua ylläpitävässä taulukossa.
     */
    private int indeksi;
    /**
     * Etäisyys lähtösolmuun.
     */
    public int alkuun;
    /**
     * Arvioitu etäisyys maalisolmuun.
     */
    public int maaliin;
    
    public Solmu(int X, int Y, int h, int i) {
        x = X;
        y = Y;
        hinta = h;
        alkuun = 0;
        maaliin = 0;
        indeksi = i;
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
     * Getteri Solmun uniikille indeksi-numerolle.
     * 
     * @return Solmun indeksi
     */
    public int indeksi() {
        return indeksi;
    }
    
    /**
     * Tulostaa Solmun koordinaatin
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    /**
     * Metodi kahden Solmun vertailuun. Vertailu perustuu etäisyysarvioihin lähtö- ja maalisolmuihin.
     * Ainoastaan A*-algoritmi muuttaa solmun etäisyyttä maaliin, muut algoritmit jättävät sen nollaksi jolloin se ei vaikuta etäisyysarvioon.
     * 
     * @param o vertailtava solmu
     * @return positiivnen jos tämän solmun etäisyys on suurempi, nolla jos etäisyydet ovat samat, negatiivinen jos toisen etäisyys on suurempi
     */
    @Override
    public int compareTo(Object o) {
        Solmu s = (Solmu)o;
        
        int tama = this.alkuun + this.maaliin;
        int tuo = s.alkuun + s.maaliin;
        
        return tama - tuo;
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
