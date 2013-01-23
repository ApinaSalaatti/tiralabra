/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.logiikka.algoritmit;

/**
 * Luokka joka kuvaa kartan yhtä ruutua koordinaateilla (x, y), toisin sanoen yhtä verkon solmua.
 * 
 * @author merioksa
 */
public class Solmu {
    /**
     * Solmun x-koordinaatti.
     */
    private int x;
    /**
     * Solmun y-koordinaatti.
     */
    private int y;
    
    public Solmu(int X, int Y) {
        x = X;
        y = Y;
    }
    
    /**
     * Getteri Solmun x-koordinaatille.
     * 
     * @return Solmun x-koordinaatti.
     */
    public int getX() {
        return x;
    }
    /**
     * Getteri Solmun y-koordinaatille.
     * 
     * @return Solmun y-koordinaatti.
     */
    public int getY() {
        return y;
    }
}
