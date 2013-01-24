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
public class BellmanFordTest {
    char[][] testikarttaCh = { {'.', '#', '.', '.', '.'},
                               {'.', '#', '.', '#', '.'},
                               {'.', '.', '.', '#', '.'} };
    
    Solmu[][] testikartta;
    
    public BellmanFordTest() {
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
        BellmanFord bf = new BellmanFord();
        bf.aja(testikartta, testikartta[0][0], testikartta[2][4]);
    }
}
