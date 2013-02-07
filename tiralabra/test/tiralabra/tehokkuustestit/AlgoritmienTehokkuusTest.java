/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tehokkuustestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import tiralabra.logiikka.Kartta;
import tiralabra.logiikka.algoritmit.*;
import tiralabra.komennot.AsetaKarttaKomento;
import tiralabra.util.Tiedostonlukija;
/**
 *
 * @author merioksa
 */
public class AlgoritmienTehokkuusTest {
    private Kartta kartta;
    private Dijkstra dijkstra;
    private BellmanFord bellmanFord;
    private Astar astar;
    
    public AlgoritmienTehokkuusTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        kartta = new Kartta();
        dijkstra = new Dijkstra();
        bellmanFord = new BellmanFord();
        astar = new Astar();
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Testimetodi joka mittaa kunkin algoritmin suoritukseen kuluneen ajan annetulla kartalla.
     * Nämä tiedot kirjaan erilliseen testiraporttiin.
     */
    @Test
    public void testaaAikoja() {
        char[][] karttaCh = Tiedostonlukija.tiedostoTauluun("testikartta.txt");
        kartta.asetaKartta(karttaCh);
        
        long d = 0; // Dijkstra
        long b = 0; // Bellman-Ford
        long a = 0; // A*
        
        kartta.tulosta();
        
        long alku = System.currentTimeMillis();
        dijkstra.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        d = System.currentTimeMillis() - alku;
        
        alku = System.currentTimeMillis();
        bellmanFord.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        b = System.currentTimeMillis() - alku;
        
        alku = System.currentTimeMillis();
        astar.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        a = System.currentTimeMillis() - alku;
        
        System.out.println("Kartan koko: " + karttaCh.length * karttaCh[0].length + " solmua");
        System.out.println("Dijkstra: " + d + "ms");
        System.out.println("A*: " + a + "ms");
        System.out.println("Bellman-Ford: " + b + "ms");
    }
    
    /*
    @Test
    public void testaaPienta() {
        char[][] karttaCh = {{'.'}};
        kartta.asetaKartta(karttaCh);
        dijkstra.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        bellmanFord.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        astar.aja(kartta.kartta(), kartta.alku(), kartta.maali());
    }
    
    @Test
    public void testaaIsoa() {
        char[][] karttaCh = Tiedostonlukija.tiedostoTauluun("isokartta.txt");
        kartta.asetaKartta(karttaCh);
        dijkstra.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        bellmanFord.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        astar.aja(kartta.kartta(), kartta.alku(), kartta.maali());
    }
    
    @Test
    public void testaaMutkikasta() {
        char[][] karttaCh = Tiedostonlukija.tiedostoTauluun("mutkikaskartta.txt");
        kartta.asetaKartta(karttaCh);
        dijkstra.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        bellmanFord.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        astar.aja(kartta.kartta(), kartta.alku(), kartta.maali());
    }
    
    @Test
    public void testaaTosiIsoa() {
        char[][] karttaCh = Tiedostonlukija.tiedostoTauluun("tosiisokartta.txt");
        kartta.asetaKartta(karttaCh);
        dijkstra.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        bellmanFord.aja(kartta.kartta(), kartta.alku(), kartta.maali());
        astar.aja(kartta.kartta(), kartta.alku(), kartta.maali());
    }
    */
}
