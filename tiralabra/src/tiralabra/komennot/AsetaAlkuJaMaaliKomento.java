package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 * Komento, jolla asetetaan käytössä olevalle kartalle halutut lähtö- ja maalikoordinaatit, joiden välille algoritmit etsivät reitin.
 * 
 * @author Merioksan Mikko
 */
public class AsetaAlkuJaMaaliKomento implements Komento {
    @Override
    public String kuvaus() {
        return "Aseta lähtö- ja maalikoordinaatit.";
    }
    
    @Override
    public void suorita(Ohjelma o) {
        asetaAlku(o);
        asetaMaali(o);
    }
    
    /**
     * Kysytään käyttäjältä halutut lähtösolmun koordinaatit ja asetetaan ne asianmukaisesti.
     */
    public void asetaAlku(Ohjelma o) {
        System.out.println("Anna aloitussolmun x-koordinaatti:");
        int x = o.getLukija().nextInt();
        System.out.println("Anna aloitussolmun y-koordinaatti:");
        int y = o.getLukija().nextInt();
        o.getLogiikka().asetaAlku(x, y);
    }
    /**
     * Kysytään käyttäjältä halutut maalisolmun koordinaatit ja asetetaan ne.
     */
    public void asetaMaali(Ohjelma o) {
        System.out.println("Anna maalisolmun x-koordinaatti:");
        int x = o.getLukija().nextInt();
        System.out.println("Anna maalisolmun y-koordinaatti:");
        int y = o.getLukija().nextInt();
        o.getLogiikka().asetaMaali(x, y);
    }
}
