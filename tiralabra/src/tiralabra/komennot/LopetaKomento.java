/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.komennot;

import tiralabra.Ohjelma;
/**
 *
 * @author merioksa
 */
public class LopetaKomento implements Komento {
    
    @Override
    public String kuvaus() {
        return "Lopeta ohjelma";
    }
    
    @Override
    public void suorita(Ohjelma o) {
        o.lopeta();
    }
}
