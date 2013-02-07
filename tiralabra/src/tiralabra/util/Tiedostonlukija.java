/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.util;

import java.io.File;
import java.util.Scanner;
import tiralabra.logiikka.tietorakenteet.LinkitettyLista;
/**
 * Apuluokka joka sisältää metodin tiedoston sisällön lukemiseksi char[][]-tauluun
 * 
 * @author Merioksan Mikko
 */
public class Tiedostonlukija {
   /**
     * Luetaan annetun nimisen tiedoston sisältö char[][]-tauluun.
     * @param nimi luettavan tiedoston nimi
     * @return char[][]-taulukko johon tiedosto luettiin
     */
   public static char[][] tiedostoTauluun(String nimi) {
       Scanner s = tiedostoLukijaan(nimi);
        
       LinkitettyLista<String> rivit = new LinkitettyLista<String>();
       while(s.hasNextLine()) {
           rivit.lisaa(s.nextLine());
       }

       return listastaCharTauluun(rivit);
   }
   
   /**
     * Luetaan annetulla tiedostonimellä löytyvä tiedosto Scanner-lukijaan.
     * 
     * @param nimi Avattavan tiedoston nimi
     * 
     * @return Scanner-olio johon tiedosto luettu
     */
    private static Scanner tiedostoLukijaan(String nimi) {
        try {
            File tiedosto = new File(nimi);
            
            return new Scanner(tiedosto);
            
        } catch(Exception e) {
            System.out.println("Tiedoston avaaminen epäonnistui!");
            
            return null;
        }
    }
    
    /**
     * Apumetodi joka muuttaa annetun merkkijonoja sisältävän ArrayListin char[][]-tauluksi.
     * Kaikkien rivien on syytä olla yhtä pitkiä!
     * 
     * @param lista lista josta kartta luetaan
     * @return Kartta char[][]-taulukkona
     */
    private static char[][] listastaCharTauluun(LinkitettyLista<String> lista) {
        char[][] palautus = new char[lista.koko()][lista.ensimmainen().length()];
        
        for(int i = 0; i < lista.koko(); i++) {
            for(int j = 0; j < lista.ensimmainen().length(); j++) {
                palautus[i][j] = lista.hae(i).charAt(j);
            }
        }
        
        return palautus;
    }
}
