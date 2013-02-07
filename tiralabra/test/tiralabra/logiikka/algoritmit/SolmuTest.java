/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.algoritmit;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ApinaSalaatti
 */
public class SolmuTest {
    
    public SolmuTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void vertailu() {
        Solmu s1 = new Solmu(0, 0, 10, 1);
        Solmu s2 = new Solmu(0, 1, 10, 2);
        s1.alkuun = 1111111;
        s2.alkuun = 121212121;
        
        assertTrue(s1.compareTo(s2) < 0);
    }
    
    @Test
    public void yhtalaisyys() {
        Solmu s1 = new Solmu(0, 0, 1, 1);
        Solmu s2 = new Solmu(0, 0, 10, 2);
        Solmu s3 = new Solmu(0, 1, 1, 1);
        s1.alkuun = 1111;
        
        assertTrue(s1.equals(s2));
        assertFalse(s1.equals(s3));
    }
}
