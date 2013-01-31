
package tiralabra.logiikka.tietorakenteet;

/**
 * Kahteen suuntaan linkitetyn listan toteuttava luokka.
 * Lista käyttää hyväkseen javan mahdollisuuksia "geneeriseen ohjelmointiin", jolloin yhdestä Lista-luokasta voi helposti luoda eri tyyppejä säilyttäviä listoja.
 * 
 * @author merioksa
 */
public class LinkitettyLista<K> {
    /**
     * Listan ensimmäinen solmu.
     */
    private Listasolmu<K> ensimmainen;
    /**
     * Listan viimeinen solmu
     */
    private Listasolmu<K> viimeinen;
    /**
     * Listan sisäinen sisäinen osoitin, joka pitää kirjaa mitä solmua on viimeksi käsitelty. Listan läpikäyntiä varten.
     */
    private Listasolmu<K> nykyinen;
    /**
     * Listan solmujen lukumäärä.
     */
    private int koko;
    
    /**
     * Tyhjä konstruktori.
     */
    public LinkitettyLista() {
        
    }
    
    /**
     * Palautetaan ensimmäiseen solmuun talletettu tietoalkio. Asettaa sisäisen osoittimen osoittamaan ensimmäiseen solmuun.
     * 
     * @return Ensimmäisen solmun sisältämä data.
     */
    public K ensimmainen() {
        nykyinen = ensimmainen;
        
        if(nykyinen != null) {
            return nykyinen.data();
        }
        else {
            return null;
        }
    }
    
    /**
     * Palautetaan tämän hetkistä sijaintia seuraavaan solmuun talletettu tietoalkio. Asettaa sisäisen osoittimen osoittamaan kyseiseen solmuun.
     * 
     * @return Seuraavan solmun sisältämä data.
     */
    public K seuraava() {
        nykyinen = nykyinen.seuraava();
        
        if(nykyinen != null) {
            return nykyinen.data();
        }
        else {
            return null;
        }
    }
    
    /**
     * Palauttaa listan indx:n tietoalkion. Siirtää sisäisen osoittimen kyseiseen alkioon.
     * 
     * @param indx halutun alkion indeksi.
     * 
     * @return haluttu tietoalkio.
     */
    public K hae(int indx) {
        if(indx >= koko || indx < 0) {
            return null; // liian suuri tai liian pieni indeksi
        }
        
        nykyinen = ensimmainen;
        int i = 0;
        
        while(i < indx) {
            nykyinen = nykyinen.seuraava();
            i++;
        }
        
        return nykyinen.data();
    }
    
    /**
     * Lisätään listalle uusi tyyppiä K oleva tietoalkio.
     * 
     * @param k Lisättävä alkio
     */
    public void lisaa(K k) {
        Listasolmu uusi = new Listasolmu(k);
        if(ensimmainen == null) {
            ensimmainen = viimeinen = uusi; // lista on tyhjä, uusi solmu on siis sekä ensimmäinen että viimeinen
        }
        else {
            viimeinen.seuraava(uusi);
            uusi.edellinen(viimeinen);
            viimeinen = uusi;
        }
        
        koko++;
    }
    
    /**
     * Poistetaan annetun data-alkion sisältävä solmu listasta. Lista käydään läpi järjestyksessä alusta lähtien kunnes oikea alkio löytyy tai lista loppuu.
     * 
     * @param k poistettava data
     * @return false, mikäli kyseistä dataa ei listalta löytynyt
     */
    public boolean poista(K k) {
        Listasolmu s = ensimmainen;
        
        if(s == null) {
            return false;
        }
        
        while(s != null && !k.equals(s.data())) {
            s = s.seuraava();
        }
        
        if(s != null && k.equals(s.data())) {
            poista(s);
            return true;
        }
        
        return false;
    }
    /**
     * Poistetaan annettu solmu listalta.
     * 
     * @param s poistettava solmu 
     */
    public void poista(Listasolmu s) {
        Listasolmu edel = s.edellinen();
        Listasolmu seur = s.seuraava();
        
        if(edel != null) {
            edel.seuraava(seur);
        }
        else {
            ensimmainen = seur; // edellistä ei ollut, eli olimme listan kärjessä
        }
        
        if(seur != null) {
            seur.edellinen(edel);
        }
        else {
            viimeinen = edel; // seuraavaa ei ollut, eli olimme listan lopussa
        }
        
        koko--;
    }
    
    /**
     * Palautetaan listan solmujen lukumäärä.
     * 
     * @return Solmujen lukumäärä
     */
    public int koko() {
        return koko;
    }
    
    /**
     * Palauttaa tiedon siitä, onko lista tällä hetkellä tyhjä.
     * 
     * @return jos listan koko on nolla, palautetaan false.
     */
    public boolean tyhja() {
        return koko == 0;
    }
}
