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
public interface Komento {
    public String kuvaus();
    public void suorita(Ohjelma o);
}
