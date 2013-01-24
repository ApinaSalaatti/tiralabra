/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.algoritmit;

import org.junit.*;
import static org.junit.Assert.*;

import tiralabra.logiikka.Kartta;
/**
 *
 * @author ApinaSalaatti
 */
public class DijkstraTest {
    char[][] testikarttaCh = { {'.', '.', '.', '.', '.'},
                               {'#', '#', '.', '#', '#'},
                               {'#', '#', '.', '.', '.'} };
    
    Solmu[][] testikartta;
    
    public DijkstraTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        Kartta k = new Kartta();
        k.asetaKartta(testikarttaCh);
        testikartta = k.kartta();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testaaAjoa() {
        Dijkstra d = new Dijkstra();
        
        d.aja(testikartta, testikartta[0][0], testikartta[1][1]);
    }
}
