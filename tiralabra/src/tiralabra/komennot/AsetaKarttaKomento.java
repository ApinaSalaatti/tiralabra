/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.komennot;

import java.util.Scanner;
import tiralabra.Ohjelma;

/**
 * Komento jolla asetetaan uusi kartta algoritmien läpikäytäväksi.
 * Kartta voidaan joko lukea tiedostosta tai antaa rivi kerrallaan.
 * 
 * @author merioksa
 */
public class AsetaKarttaKomento implements Komento {
    private Scanner lukija;
    
    @Override
    public String kuvaus() {
        return "Aseta käytettävä kartta";
    }
    
    @Override
    public void suorita(Ohjelma o) {
        lukija = o.getLukija();
        
        System.out.println("1 : tiedostosta");
        System.out.println("2 : rivi kerrallaan");
        int komento = lukija.nextInt();
        
        if(komento == 1) {
            tiedostosta();
        }
        else if(komento == 2) {
            riveittain();
        }
        else {
            System.out.println("Virheellinen komento!");
        }
    }
    
    /**
     * Kysytään käyttäjältä tiedostonimi ja luetaan sieltä karttadata.
     */
    public void tiedostosta() {
        System.out.println("Anna tiedostonimi:");
    }
    
    /**
     * Luetaan käyttäjältä karttadata rivi kerrallaan.
     */
    public void riveittain() {
        boolean jatka = true;
        int rivi = 1;
        
        while(jatka) {
            System.out.println("Anna " + rivi + ". rivi (tyhjä rivi lopettaa)");
            String riviStr = lukija.nextLine();
            
            if(riviStr == null || riviStr.equals("")) {
                jatka = false;
            }
            else {
                
            }
            
            rivi++;
        }
    }
    
    public char[][] stringTaulustaCharTauluun(String[] t) {
        char[][] palautus = new char[t.length][t[0].length()];
        
        return palautus;
    }
}
