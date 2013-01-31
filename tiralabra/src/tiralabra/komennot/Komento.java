
package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 * Rajapinta jonka kaikki ohjelmaan lisättävät komennot toteuttavat.
 * 
 * @author merioksa
 */
public interface Komento {
    /**
     * Palauttaa toiminnon kuvauksen (eli selityksen mitä toiminto tekee) käyttöliittymää varten.
     * 
     * @return Tekstimuotoinen kuvaus komennon toiminnasta
     */
    public String kuvaus();
    /**
     * Suorittaa komennon
     * 
     * @param o Ohjelma jonka metodeja komento kutsuu
     */
    public void suorita(Ohjelma o);
}
