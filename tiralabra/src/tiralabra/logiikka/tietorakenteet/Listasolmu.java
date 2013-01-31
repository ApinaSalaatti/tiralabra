package tiralabra.logiikka.tietorakenteet;

/**
 * Linkitetyn listan yhtä solmua/yksikköä kuvaava luokka.
 * Sisältää solmuun talletetun datan, sekä viitteen seuraavaan solmuun listassa.
 * 
 * @author Merioksan Mikko
 */
public class Listasolmu<K> {
    /**
     * Solmuun talletettu data (voi geneerisyyden ansiosta olla mitä vain).
     */
    private K data;
    /**
     * Solmua seuraava solmu.
     */
    private Listasolmu seuraava;
    /**
     * Solmua edeltävä solmu.
     */
    private Listasolmu edellinen;
    
    /**
     * Konstruktori, joka saa parametrina solmuun talletettavan datan.
     * 
     * @param k Talletettava data, voi olla mitä tahansa tyyppiä. 
     */
    public Listasolmu(K k) {
        this.data = k;
        seuraava = null;
        edellinen = null;
    }
    
    /**
     * Palautetaan solmuun talletettu data.
     * 
     * @return Solmuun talletettu data.
     */
    public K data() {
        return data;
    }
    
    /**
     * Metodi joka asettaa listasolmulle seuraaja-solmun.
     * 
     * @param s Seuraajaksi asetettava Listasolmu
     */
    public void seuraava(Listasolmu s) {
        seuraava = s;
    }
    /**
     * Palauttaa solmun seuraajan.
     * 
     * @return Tätä solmua seuraava Listasolmu.
     */
    public Listasolmu seuraava() {
        return seuraava;
    }
    
    /**
     * Metodi joka asettaa listasolmulle edeltäjä-solmun.
     * 
     * @param s Edeltäjäksi asetettava Listasolmu
     */
    public void edellinen(Listasolmu s) {
        edellinen = s;
    }
    /**
     * Palauttaa solmun edeltäjän.
     * 
     * @return Tätä solmua edeltävä Listasolmu.
     */
    public Listasolmu edellinen() {
        return edellinen;
    }
}
