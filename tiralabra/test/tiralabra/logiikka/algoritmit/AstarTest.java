package tiralabra.logiikka.algoritmit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;
import tiralabra.logiikka.Kartta;
import tiralabra.logiikka.algoritmit.Solmu;

/**
 *
 * @author ApinaSalaatti
 */
public class AstarTest {
    char[][] testikarttaCh = { {'.', '#', '.', '.', '.'},
                               {'.', '#', '.', '#', '.'},
                               {'.', '.', '.', '#', '.'} };
    
    Solmu[][] testikartta;
    
    public AstarTest() {
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
        Astar a = new Astar();
        a.aja(testikartta, testikartta[0][0], testikartta[2][4]);
    }
}
