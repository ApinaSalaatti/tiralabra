package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 *
 * @author Merioksan Mikko
 */
public class AjaAlgoritmiKomento implements Komento {
    @Override
    public String kuvaus() {
        return "Aja algoritmi";
    }
    
    @Override
    public void suorita(Ohjelma o) {
        o.getLogiikka().ajaAlgoritmi("Dijkstra");
    }
}
