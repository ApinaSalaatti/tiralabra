/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.komennot;

import java.io.File;
import java.util.ArrayList;
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
        
        char[][] kartta = null;
        if(komento == 1) {
            kartta = tiedostosta();
        }
        else if(komento == 2) {
            kartta = riveittain();
        }
        else {
            System.out.println("Virheellinen komento!");
        }
        
        if(kartta != null) {
            o.getLogiikka().asetaKartta(kartta);
        }
    }
    
    /**
     * Kysytään käyttäjältä tiedostonimi ja luetaan sieltä karttadata.
     * Data luetaan ensin merkkijonoiksi linkitettyyn listaan ja muutetaan sitten char[][]-taulukoksi.
     */
    public char[][] tiedostosta() {
        System.out.println("Anna tiedostonimi:");
        String nimi = lukija.nextLine();
        try {
            File tiedosto = new File(nimi);
            Scanner s = new Scanner(tiedosto);
            
            ArrayList<String> rivit = new ArrayList<String>();
            while(s.hasNextLine()) {
                rivit.add(s.nextLine());
            }
            return arrayLististaCharTauluun(rivit);
        } catch(Exception e) {
            System.out.println("Tiedoston avaaminen epäonnistui!");
            //e.printStackTrace();
        }
        
        // jokin meni pieleen, palautetaan null
        return null;
    }
    
    /**
     * Luetaan käyttäjältä karttadata rivi kerrallaan.
     */
    public char[][] riveittain() {
        boolean jatka = true;
        int rivi = 1;
        
        ArrayList<String> rivit = new ArrayList<String>();
        while(jatka) {
            System.out.println("Anna " + rivi + ". rivi (tyhjä rivi lopettaa)");
            String riviStr = lukija.nextLine();
            
            if(riviStr == null || riviStr.equals("")) {
                jatka = false;
            }
            else {
                rivit.add(riviStr);
            }
            
            rivi++;
        }
        
        return arrayLististaCharTauluun(rivit);
    }
    
    /**
     * Apumetodi joka muuttaa annetun merkkijonoja sisältävän ArrayListin char[][]-tauluksi.
     * Kaikkien rivien on syytä olla yhtä pitkiä!
     * 
     * @param lista lista josta kartta luetaan
     * @return char[][]-taulukko
     */
    public char[][] arrayLististaCharTauluun(ArrayList<String> lista) {
        char[][] palautus = new char[lista.size()][lista.get(0).length()];
        
        for(int i = 0; i < lista.size(); i++) {
            for(int j = 0; j < lista.get(0).length(); j++) {
                palautus[i][j] = lista.get(i).charAt(j);
            }
        }
        
        return palautus;
    }
}
