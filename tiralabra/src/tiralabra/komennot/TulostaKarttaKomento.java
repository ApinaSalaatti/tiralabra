package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 * Käyttöliittymään kartan tulostava komento.
 * 
 * @author Merioksan Mikko
 */
public class TulostaKarttaKomento implements Komento {
    @Override
    public String kuvaus() {
        return "Tulosta kartta";
    }
    
    @Override
    public void suorita(Ohjelma o) {
        o.getLogiikka().tulostaKartta();
    }
}
