package tiralabra.logiikka.tietorakenteet;

/**
 * Yhtä keon solmua kuvaava luokka. Solmu ei tee muuta kuin kapseloi jotakin tietotyyppiä edustavan data-alkion.
 * 
 * @author Merioksan Mikko
 */
public class Kekosolmu<K> {
    /**
     * Solmuun talletettu data (voi geneerisyyden ansiosta olla mitä vain).
     */
    private K data;
    
    /**
     * Konstruktori, joka saa parametrina solmuun talletettavan datan.
     * 
     * @param k Talletettava data, voi olla mitä tahansa tyyppiä. 
     */
    public Kekosolmu(K k) {
        this.data = k;
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
     * Asetetaan kekosolmun data-alkioksi parametrina annettu data.
     * 
     * @param k solmuun tallennettava data
     */
    public void data(K k) {
        data = k;
    }
}
