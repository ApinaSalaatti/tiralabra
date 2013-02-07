package tiralabra.logiikka.tietorakenteet;

/**
 * Minimikeko, eli pino jonka päällimmäisenä alkiona on aina sen pienin alkio.
 * Keko käyttää hyväkseen javan mahdollisuuksia geneeriseen ohjelmointiin, jolloin yhdestä Keko-luokasta voi helposti luoda eri tyyppejä säilyttäviä kekoja.
 * Kekoon talletettavien alkioiden täytyy toteuttaa javan oma Comparable-rajapinta.
 * 
 * @author Merioksan Mikko
 */
public class Minimikeko<K extends Comparable> {
    private Kekosolmu<K>[] keko;
    private int koko;
    
    /**
     * Konstruktori joka asettaa keon maksimikooksi 1.
     */
    public Minimikeko() {
        keko = new Kekosolmu[1];
        koko = 0;
    }
    /**
     * Konstruktori, joka asettaa keon maksimikooksi parametrina annetun arvon.
     * 
     * @param k keon alkuperäinen maksimikoko
     */
    public Minimikeko(int k) {
        keko = new Kekosolmu[k];
        koko = 0;
    }
    
    /**
     * Alkion lisäys kekoon. Lisäyksen jälkeen varmistetaan aina kekoehdon säilyminen.
     * 
     * @param k lisättävä alkio
     */
    public void lisaa(K k) {
        if(koko == keko.length) {
            Kekosolmu[] uusiKeko = new Kekosolmu[2 * keko.length]; // keon täyttyessä tuplataan sen koko
            System.arraycopy(keko, 0, uusiKeko, 0, keko.length);
            keko = uusiKeko;
        }
        
        keko[koko] = new Kekosolmu(k);
        jarjestaYlos(koko);
        koko++;
    }
    
    /**
     * Palauttaa ja poistaa keon pienimmän alkion.
     * 
     * @return keon pienin alkio
     */
    public K poll( ) {
        if(koko > 0) {
            K min = keko[0].data();
            keko[0] = keko[koko - 1];

            koko--;

            if(koko > 0) {
                jarjestaAlas(0);
            }
            
            return min;
        }
        return null;
    }
    
    /**
     * Varmistaa että kekoehto on voimassa annetun datan sisältävästä indeksistä ylöspäin. Mikäli kyseistä dataa ei ole kekoon talletettu, ei tehdä mitään.
     * 
     * @param k data jonka indeksistä keko järjestetään
     */
    public void jarjestaYlos(K k) {
        Kekosolmu<K> s = null;
        int i = 0;
        while(i < koko) {
            if(keko[i].data().equals(k)) {
                s = keko[i];
                break;
            }
            i++;
        }
        
        if(s != null) {
            jarjestaYlos(i);
        }
    }
    
    /**
     * Varmistaa että kekoehto on voimassa annetusta indeksistä ylöspäin.
     * 
     * @param i kohta josta kekoa lähdetään tarkistamaan
     */
    public void jarjestaYlos(int i) {
        if(i > 0) {
            int vanhempi = (i - 1) / 2;
            if(keko[vanhempi].data().compareTo(keko[i].data()) > 0) {
                vaihda(vanhempi, i);
                jarjestaYlos(vanhempi);
            }
        }
    }
    
    /**
     * Varmistaa että kekoehto säilyy annetusta kohdasta alaspäin ("heapify").
     * 
     * @param i kohta josta kekoa lähdetään tarkistamaan
     */
    public void jarjestaAlas(int i) {
        int vasen = 2 * i + 1;
        int oikea = 2 * i + 2;
        int pienin;
 
        if(oikea < koko) {
            if(keko[vasen].data().compareTo(keko[oikea].data()) < 0) {
                pienin = vasen;
            }
            else {
                pienin = oikea;
            }
            
            if(keko[i].data().compareTo(keko[pienin].data()) > 0) {
                vaihda(i, pienin);
                jarjestaAlas(pienin);
            }
        }
        else if(vasen == koko-1 && keko[i].data().compareTo(keko[vasen].data()) > 0) {
            vaihda(i, vasen);
        }
            
    }
    
    /**
     * Apumetodi joka vaihtaa kahden indeksin alkioiden paikkaa
     * 
     * @param i alkio 1
     * @param j alkio 2
     */
    private void vaihda(int i, int j) {
        Kekosolmu tmp = keko[i];
        
        keko[i] = keko[j];
        keko[j] = tmp;
    }
    
    /**
     * Palauttaa tiedon, jos keko on tyhjä.
     * 
     * @return true, jos keossa ei ole jäljellä yhtään alkiota
     */
    public boolean tyhja() {
        return koko == 0;
    }
    
    /**
     * Palauttaa keon koon
     * 
     * @return keon koko
     */
    public int koko() {
        return koko;
    }
    
    /**
     * Poistaa annetun alkion keosta, mikäli se sieltä löytyy.
     * @param k poistettava alkio
     * @return false, mikäli haluttua alkiota ei löytynyt keosta
     */
    public boolean poista(K k) {
        for(int i = 0; i < koko; i++) {
            if(keko[i].data().equals(k)) {
                keko[i] = keko[koko - 1];
                koko--;
                jarjestaAlas(0);
                return true;
            }
        }
        
        return false; // ei löytynyt
    }
}
