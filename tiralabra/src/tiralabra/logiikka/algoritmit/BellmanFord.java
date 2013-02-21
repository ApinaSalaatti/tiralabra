
package tiralabra.logiikka.algoritmit;

/**
 * Bellman-Fordin algoritmin toteuttava luokka.
 * 
 * @author merioksa
 */
public class BellmanFord extends Algoritmi {
 
    public BellmanFord() {
        
    }
    
    @Override
    public void aja(Solmu[][] kartta, Solmu alku, Solmu maali) {
        this.kartta = kartta;
                
        aloitusSolmu = alku;
        maaliSolmu = maali;
        
        polku = new Solmu[kartta.length * kartta[0].length];
        
        long alkuAika = System.currentTimeMillis();
        ISS(kartta, alku);
        
        // kuinka monta kertaa solmut käydään läpi
        int kaaret = kartta.length * kartta[0].length;
        
        for(int i = 0; i <= kaaret; i++) {
            loysaaKaikki(kartta);
        }
        
        kulunutAika = System.currentTimeMillis() - alkuAika;
    }
    
    /**
     * Initialize single source -metodi, toisin sanoen metodi joka asettaa kaikkien kartan Solmujen etäisyydeksi "äärettömän" (eli tosi ison).
     * Lopuksi aloitussolmun etäisyydeksi asetetaan 0.
     */
    private void ISS(Solmu[][] kartta, Solmu alku) {
        for(int y = 0; y < kartta.length; y++) {
            for(int x = 0; x < kartta[0].length; x++) {
                kartta[y][x].alkuun = Integer.MAX_VALUE - 100000; // ei MAX_VALUE, koska tällöin siihen plussaaminen heittäisi sen negatiiviseksi
                polku[kartta[y][x].indeksi()] = null;
            }
        }
        
        // asetetaan alkusolmun etäisyydeksi 0
        kartta[alku.y()][alku.x()].alkuun = 0;
    }
    
    /**
     * Löysätään kaikki kartan solmut.
     * 
     * @param kartta karttaa kuvaava Solmu[][]-taulukko
     */
    public void loysaaKaikki(Solmu[][] kartta) {
        for(int y = 0; y < kartta.length; y++) {
            for(int x = 0; x < kartta[0].length; x++) {
                // löysätään kaikki naapurisolmut
                if(x > 0) {
                    loysaa(kartta[y][x], kartta[y][x - 1]); // vasemmalle
                }
                if(x < kartta[0].length - 1) {
                    loysaa(kartta[y][x], kartta[y][x + 1]); // oikealle
                }
                if(y > 0) {
                    loysaa(kartta[y][x], kartta[y - 1][x]); // ylös
                }
                if(y < kartta.length - 1) {
                    loysaa(kartta[y][x], kartta[y + 1][x]); // alas
                }
            }
        }
    }
    
    /**
     * Metodi joka "löysää" (relax) etäisyyden annettuun Solmuun v, mikäli etäisyys siihen on sen nykyistä etäisyyttä lyhyempi annetun Solmun u kautta.
     * 
     * @param u Solmu jonka kautta saavutaan
     * @param v Solmu jota löysätään
     */
    private void loysaa(Solmu u, Solmu v) {
        // TODO: pitäisikö myös kulmittain voida liikkua, niin että hintaan lisätään kerroin 1,4?
        if(v.alkuun > u.alkuun + v.hinta()) {
            v.alkuun = u.alkuun + v.hinta();
            polku[v.indeksi()] = u;
        }
    }
    
    @Override
    public void tulokset() {
        System.out.println("BELLMAN-FORD");
        super.tulokset();
    }
}
