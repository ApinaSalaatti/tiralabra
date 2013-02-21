/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.komennot;

import java.io.File;
import java.util.Scanner;
import tiralabra.logiikka.tietorakenteet.LinkitettyLista;
import tiralabra.Ohjelma;
import tiralabra.util.Tiedostonlukija;

/**
 * Komento jolla asetetaan uusi kartta algoritmien läpikäytäväksi.
 * Kartta voidaan joko lukea tiedostosta tai antaa rivi kerrallaan.
 * 
 * @author merioksa
 */
public class AsetaKarttaKomento implements Komento {
    private Scanner lukija;
    
    /**
     * Konstruktori ei tee mitään.
     */
    public AsetaKarttaKomento() {
    }
    
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
        
        // tyhjennetään lukijasta sinne jäävä tyhjä rivi (en ymmärrä näköjään edes perusasioita kun en tajua miksi se siellä on joka kerta)
        lukija.nextLine();
        
        char[][] kartta = lueKartta(komento);
        
        if(kartta != null) {
            o.getLogiikka().asetaKartta(kartta);
        }
    }
    
    /**
     * Valitaan kartanlukutapa käyttäjän antaman numeron mukaisesti.
     * 
     * @param komento käytättäjän antaman komennon numero
     * 
     * @return luettu kartta
     */
    public char[][] lueKartta(int komento) {
        char[][] kartta = null;
        
        switch(komento) {
            case 1:
                kartta = tiedostosta();
                break;
            case 2:
                kartta = riveittain();
                break;
            default:
                System.out.println("Virheellinen komento!");
                break;
        }
        
        return kartta;
    }
    
    /**
     * Kysytään käyttäjältä tiedostonimi ja luetaan sieltä karttadata.
     * Data luetaan ensin merkkijonoiksi linkitettyyn listaan ja muutetaan sitten char[][]-taulukoksi.
     */
    public char[][] tiedostosta() {
        System.out.println("Anna tiedostonimi:");
        String nimi = lukija.nextLine();
        try {
            char[][] kartta = Tiedostonlukija.tiedostoTauluun(nimi);
            return kartta;
        } catch(Exception e) {
            System.out.println("Ongelma tiedoston lukemisessa!");
        }
        
        return null;
    }
    
    /**
     * Luetaan käyttäjältä karttadata rivi kerrallaan. Rivit tallennetaan ensin linkitettyyn listaan ja sitten siitä char[][]-tauluun.
     */
    public char[][] riveittain() {
        boolean jatka = true;
        int rivi = 1;
        
        LinkitettyLista<String> rivit = new LinkitettyLista<String>();
        while(jatka) {
            System.out.println("Anna " + rivi + ". rivi (tyhjä rivi lopettaa)");
            String riviStr = lukija.nextLine();
            
            jatka = tarkastaRivi(riviStr, rivit);
            
            rivi++;
        }
        
        return listastaCharTauluun(rivit);
    }
    
    /**
     * Tarkastaa yhden käyttäjän antaman rivin. Jos rivi ei ole tyhjä, sen sisältö lisätään parametrina annettuun listaan.
     * Rivin ollessa tyhjä palautetaan false.
     * 
     * @param riviStr Tarkastettava merkkijono
     * @param rivit Linkitetty lista johon rivi talletetaan.
     * 
     * @return false, mikäli rivi on tyhjä merkkijono
     */
    public boolean tarkastaRivi(String riviStr, LinkitettyLista<String> rivit) {
        if(riviStr == null || riviStr.equals("")) {
            return false;
        }
        else {
            rivit.lisaa(riviStr);
            return true;
        }
    }
    
    /**
     * Luetaan annetulla tiedostonimellä löytyvä tiedosto Scanner-lukijaan.
     * 
     * @param nimi Avattavan tiedoston nimi
     * 
     * @return Scanner-olio johon tiedosto luettu
     */
    public Scanner tiedostoLukijaan(String nimi) {
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
    public char[][] listastaCharTauluun(LinkitettyLista<String> lista) {
        char[][] palautus = new char[lista.koko()][lista.ensimmainen().length()];
        
        for(int i = 0; i < lista.koko(); i++) {
            for(int j = 0; j < lista.ensimmainen().length(); j++) {
                palautus[i][j] = lista.hae(i).charAt(j);
            }
        }
        
        return palautus;
    }
}
