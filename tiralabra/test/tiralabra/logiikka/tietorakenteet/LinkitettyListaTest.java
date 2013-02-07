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
public class LinkitettyListaTest {
    LinkitettyLista<String> testilista;
    
    public LinkitettyListaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        testilista = new LinkitettyLista<String>();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaaminenToimii() {
        testilista.lisaa("Moi");
        assertTrue(testilista.ensimmainen().equals("Moi"));
    }
    
    @Test
    public void kokoOikein() {
        testilista.lisaa("Moi1");
        testilista.lisaa("Moi2");
        testilista.lisaa("Moi3");
        
        assertTrue(testilista.koko() == 3);
    }
    
    @Test
    public void poistaminen() {
        testilista.lisaa("Jee");
        testilista.lisaa("JOO");
        
        assertTrue(testilista.poista("Jee"));
        assertFalse(testilista.poista("Jee"));
    }
}
