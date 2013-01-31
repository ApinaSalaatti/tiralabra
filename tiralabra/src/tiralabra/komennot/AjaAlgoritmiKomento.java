package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 * Komento jolla suoritetaan haluttu algoritmi (tai kaikki kerralla).
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
        System.out.println("Valitse suoritettava algoritmi:");
        System.out.println("1. Bellman-Ford");
        System.out.println("2. Dijkstra");
        System.out.println("3. A*");
        System.out.println("4. Kaikki");
        int algo = o.getLukija().nextInt();
        
        valitseAlgoritmi(algo, o);
    }
    
    public void valitseAlgoritmi(int algo, Ohjelma o) {
        switch(algo) {
            case 1:
                o.getLogiikka().ajaAlgoritmi("Bellman-Ford");
                break;
            case 2:
                o.getLogiikka().ajaAlgoritmi("Dijkstra");
                break;
            case 3:
                o.getLogiikka().ajaAlgoritmi("Astar");
                break;
            case 4:
                o.getLogiikka().ajaAlgoritmi("Kaikki");
                break;
        }
    }
}
