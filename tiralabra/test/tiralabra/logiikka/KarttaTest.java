/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka;

import org.junit.*;
import static org.junit.Assert.*;
import tiralabra.logiikka.algoritmit.Solmu;

/**
 *
 * @author ApinaSalaatti
 */
public class KarttaTest {
    char[][] testikarttaCh = { {'.', '#', '.', '.', '.'},
                               {'.', '#', '.', '#', '.'},
                               {'.', '.', '.', '#', '.'} };
    private Kartta kartta;
    
    public KarttaTest() {
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
        kartta.asetaKartta(testikarttaCh);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void kartanSolmutOikeita() {
        Solmu[][] k = kartta.kartta();
        
        for(int i = 0; i < k.length; i++) {
            for(int j = 0; j < k[0].length; j++) {
                if(testikarttaCh[i][j] == '#') {
                    assertTrue(k[i][j].hinta() == 10);
                }
                else {
                    assertTrue(k[i][j].hinta() == 1);
                }
            }
        }
    }
    @Test
    public void koordinaattienAsetusEiHyvaksyVirheellisiaArvoja() {
        kartta.alku(-5, 3995);
        assertTrue(kartta.alku().x() >= 0);
        assertTrue(kartta.alku().y() < kartta.kartta().length);
    }
}
