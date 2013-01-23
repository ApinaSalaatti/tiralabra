/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra;

import java.util.ArrayList;
import java.util.Scanner;
import tiralabra.komennot.*;
import tiralabra.logiikka.Logiikka;
/**
 * Ohjelman pääluokka. Hallinnoi ohjelman käyttöliittymää. Logiikka on erotettu käyttöliittymän toiminnasta.
 * 
 * @see tiralabra.logiikka;
 * 
 * @author merioksa
 */
public class Ohjelma {
    /**
     * Lippumuuttuja joka kertoo tuleeko ohjelma pitää käynnissä.
     */
    private boolean kaynnissa;
    /**
     * Scanner-luokan olija jolla käyttäjältä luetaan komennot ja karttadata.
     */
    private Scanner lukija;
    /**
     * Lista kaikista ohjelman tuntemista komennoista.
     * TODO: muuta itse rakennetuksi listaksi.
     */
    private ArrayList<Komento> komennot;
    /**
     * Sovelluksen logiikka, jota tämän luokan komennoilla kutsutaan.
     */
    private Logiikka logiikka;
    
    public Ohjelma() {
        kaynnissa = true;
        lukija = new Scanner(System.in);
        komennot = new ArrayList<Komento>();
        logiikka = new Logiikka();
        
        luoKomennot();
    }
    
    /**
     * Luodaan ohjelman käyttämät komennot ja lisätään ne komento-listaan.
     */
    public void luoKomennot() {
        komennot.add(new LopetaKomento());
        komennot.add(new AsetaKarttaKomento());
    }
    
    /**
     * Getteri ohjelman logiikka-osuudelle komentoja varten.
     * 
     * @return käytössä oleva looginen komponentti.
     */
    public Logiikka getLogiikka() {
        return logiikka;
    }
    
    /**
     * Getteri ohjelman käytämälle Scanner-oliolle. Näin niitä tarvitaan vain yksi!
     * 
     * @return käytössä oleva Scanner-olio
     */
    public Scanner getLukija() {
        return lukija;
    }
    
    /**
     * Ohjelman käynnistävä metodi. Ohjelma pidetään käynnissä kunnes käyttäjä antaa ohjelman lopettavan komennon.
     */
    public void kaynnista() {
        while(kaynnissa) {
            tulostaValikko();
            
            int komento = lukija.nextInt();
            
            if(komento < 0 || komento >= komennot.size()) {
                System.out.println("Virheellinen komento!");
            }
            else {
                komennot.get(komento).suorita(this);
            }
        }
    }
    
    /**
     * Tulostaa käyttäjälle tarjolla olevat toiminnot.
     */
    public void tulostaValikko() {
        System.out.println("Anna haluamasi komennon numero:");
        for(int i = 0; i < komennot.size(); i++) {
            System.out.println(i + " : " + komennot.get(i).kuvaus());
        }
    }
    
    /**
     * Ohjelman lopetettavaksi merkitsevä metodi.
     */
    public void lopeta() {
        kaynnissa = false;
    }
    
}
