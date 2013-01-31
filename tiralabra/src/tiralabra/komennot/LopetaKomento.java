
package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 * Komento jonka suorittaminen päättää ohjelman suorituksen.
 * 
 * @author merioksa
 */
public class LopetaKomento implements Komento {
    
    @Override
    public String kuvaus() {
        return "Lopeta ohjelma";
    }
    
    @Override
    public void suorita(Ohjelma o) {
        o.lopeta();
    }
}
