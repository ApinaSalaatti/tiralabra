/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.tietorakenteet;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author ApinaSalaatti
 */
public class MinimikekoTest {
    private Minimikeko<Integer> keko;
    
    public MinimikekoTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        keko = new Minimikeko<Integer>();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testaaJarjestys() {
        keko.lisaa(5);
        keko.lisaa(8);
        keko.lisaa(6);
        keko.lisaa(1);
        keko.lisaa(4);
        
        assertTrue(keko.poll() == 1);
    }
    
    @Test
    public void kokoOikein() {
        keko.lisaa(5);
        keko.lisaa(8);
        keko.lisaa(6);
        keko.lisaa(1);
        keko.lisaa(4);
        
        assertTrue(keko.koko() == 5);
    }
}
