package tiralabra.logiikka.algoritmit;

import tiralabra.logiikka.tietorakenteet.Minimikeko;

/**
 * Abstrakti luokka, jonka kaikki projektin algoritmit toteuttavat. Tämä vähentää toistoa koodissa, sillä algoritmeillä on monia yhteisiä metodeja.
 * 
 * @author Merioksan Mikko
 */
public abstract class Algoritmi {
    /**
     * Viimeisimpään suoritukseen kulunut aika.
     */
    protected long kulunutAika;
    /**
     * Edellisessä ajossa käytetty aloitussolmu (tulosten tulostamista varten)
     */
    protected Solmu aloitusSolmu;
    /**
     * Edellisessä ajossa käytetty maalisolmu (tulosten tulostamista varten)
     */
    protected Solmu maaliSolmu;
    /**
     * Taulukko, jonka kussakin indeksissä on talletettuna se Solmu josta kyseisen indeksin omaavaan Solmuun on saavuttu.
     */
    protected Solmu[] polku;
    /**
     * Viimeksi käytetty kartta Solmu[][]-taulukkona
     */
    protected Solmu[][] kartta;
    
    public Algoritmi() {
        polku = null;
    }
    
    /**
     * Suorittaa algoritmin annetulla kartalla, lähtien annetusta lähtösolmusta.
     * 
     * @param kartta kartta jolla reittia etsitään
     * @param alku solmu josta algoritmi lähtee reittiä etsimään
     * @param maali tavoitteena oleva solmu
     */
    public abstract void aja(Solmu[][] kartta, Solmu alku, Solmu maali);
    
    
    /**
     * Tulostaa viimeisimmän ajon tulokset.
     */
    public void tulokset() {
        if(polku != null) { // jos polkua ei ole, ei algoritmiä ole vielä ajettu!
            System.out.println("Aikaa kului: " + kulunutAika + "ms");

            reitti();
        }
        else {
            System.out.println("Algoritmia ei ole ajettu vielä kertaakaan!");
        }
    }
    
    /**
     * Tulostetaan reitti jonka algoritmi löysi aloitussolmusta maalisolmuun.
     * Tämä on nyt melko tehoton systeemi, mutta toisaalta reitin tulostusta on tarkoitus käyttää lähinnä debuggaus-tarkoituksiin.
     */
    public void reitti() {
        System.out.println("Lyhin reitti solmusta " + aloitusSolmu + " solmuun " + maaliSolmu + ":");

        char[][] reitti = new char[kartta.length][kartta[0].length];
        
        luoReittikartta(reitti);
        piirraReitti(reitti);
        tulostaReitti(reitti);
    }
    
    /**
     * Yksinkertaisesti tulostaa parametrina annetun char[][]-taulun.
     * 
     * @param reitti tulostettava taulukko
     */
    private void tulostaReitti(char[][] reitti) {
        for(int y = 0; y < kartta.length; y++) {
            for(int x = 0; x < kartta[0].length; x++) {
                System.out.print(reitti[y][x]);
            }
            System.out.println();
        }
    }
    
    /**
     * Luo tulostettavan kartan viimeksi käytössä olleen kartan perusteella.
     * 
     * @param reitti char[][]-taulu johon reittikartta luodaan.
     */
    private void luoReittikartta(char[][] reitti) {
        for(int y = 0; y < kartta.length; y++) {
            for(int x = 0; x < kartta[0].length; x++) {
                if(kartta[y][x].hinta() == 10) {
                    reitti[y][x] = '#';
                }
                else {
                    reitti[y][x] = '.';
                }
            }
        }
    }
    
    /**
     * "Piirtää" löydetyn parhaan reitin kartalle, eli asettaa tulostettavan kartan reitillä oleviin indekseihin merkin 'x', aloitusindeksiin 'a' ja maali-indeksiin 'm'.
     * 
     * @param reitti char[][]-taulu jolle reitti piirretään
     */
    private void piirraReitti(char[][] reitti) {
        Solmu nyt = polku[maaliSolmu.indeksi()];
        while(nyt != null) {
            reitti[nyt.y()][nyt.x()] = 'x';
            nyt = polku[nyt.indeksi()];
        }
        
        reitti[aloitusSolmu.y()][aloitusSolmu.x()] = 'a';
        reitti[maaliSolmu.y()][maaliSolmu.x()] = 'm';
    }
}
