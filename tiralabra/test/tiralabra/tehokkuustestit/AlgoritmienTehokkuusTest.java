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
        dijkstra.tulokset();
        bellmanFord.tulokset();
        astar.tulokset();
    }
}
