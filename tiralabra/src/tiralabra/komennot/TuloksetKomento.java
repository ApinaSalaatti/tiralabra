package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 *
 * @author Merioksan Mikko
 */
public class TuloksetKomento implements Komento {
    @Override
    public String kuvaus() {
        return "Viimeisimmän ajon tulokset";
    }
    
    @Override
    public void suorita(Ohjelma o) {
        o.getLogiikka().tulokset();
    }
}
