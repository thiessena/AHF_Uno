package archiv;
import java.util.ArrayList;

public class Spiel {
    private Kartenstapel nachZiehStapel;
    private Kartenstapel ablageStapel;
    private ArrayList<UnoSpieler> players;
    private boolean reverse;
    private UnoSpieler aktuellerSpieler;
    private KonsolenView kView;

    public Spiel(KonsolenView kView) {
        nachZiehStapel = new Kartenstapel(false);
        ablageStapel = new Kartenstapel(true);
        players = new ArrayList<>();
        reverse = false;
        aktuellerSpieler = null;
        this.kView = kView;
    }

    public void addSpieler(UnoSpieler uSpieler){
        players.add(uSpieler);
    }

    public static Spiel getDefaultSpiel(KonsolenView kView){
        Spiel s = new Spiel(kView); 
        s.addSpieler(new UnoSpieler("a"));
        s.addSpieler(new UnoSpieler("b"));
        s.start();
        return s;
    }

    public UnoSpieler getAktuellerSpieler(){
        return aktuellerSpieler;
    }

    public ArrayList<UnoSpieler> getAlleSpieler(){
        return players; 
    }

    public Kartenstapel getAblagestapel(){
        return ablageStapel; 
    }

    public Kartenstapel getNachZiehstapel(){
        return nachZiehStapel;
    }

    public void start() {
        // Initialisiere das Kartendeck
        nachZiehStapel.kartenAuflegen(UnoKarte.getUnoKartenSet());
        System.out.println(nachZiehStapel.toString());
        // Mische das Kartendeck
        nachZiehStapel.shuffle();
        // Ziehe die erste Karte und lege sie auf den Ablagestapel
        ablageStapel.karteAuflegen(nachZiehStapel.karteZiehen());
        //Mache den ersten Spieler zum aktuellen Spieler
        aktuellerSpieler = players.get(0);
        //Spielern die Handkarten geben
        for(UnoSpieler spieler : players){
            ArrayList<UnoKarte> gezogeneKarten = nachZiehStapel.kartenZiehen(5); 
            spieler.getHandkarten().kartenHinzufuegen(gezogeneKarten);
            System.out.println(spieler.getHandkarten().toString());
        }
    }

    /**
     * Legt die Karte mit der kartenNummer des aktuellen Spielers.
     * @param kartenNummer
     * @return
     */
    public boolean karteSpielen(int kartenNummer){
        if(kartenNummer < 0)
            return false;
        if(kartenNummer > aktuellerSpieler.getHandkarten().getAnzahl())
            return false; 
        UnoKarte karte = aktuellerSpieler.getHandkarten().getKarte(kartenNummer); 
        if(!erlaubteKarte(karte))
            return false; 
        //Der reguläre Fall, wenn die Karte gelegt werden kann
        karte = aktuellerSpieler.getHandkarten().ziehen(kartenNummer);
        ablageStapel.karteAuflegen(karte);
        return true;
    }

    public void spielerZiehtKarte(){
        aktuellerSpieler.getHandkarten().karteHinzufuegen(nachZiehStapel.karteZiehen());
    }

    public boolean moeglicheKarten(){
        ArrayList<UnoKarte> hKarten = aktuellerSpieler.getHandkarten().getKarten(); 
        for(UnoKarte k: hKarten){
            if(erlaubteKarte(k)){
                return true;
            }
        }
        return false;
    }

    private boolean erlaubteKarte(UnoKarte karte) {
        UnoKarte k = ablageStapel.getObersteKarte();
        return karte.getFarbe().equals(k.getFarbe()) || karte.getZiffer() == k.getZiffer();
    }

    /**
     * Der nächste Spieler wird als aktueller Spieler gesetzt.
     */
    public void naechsteSpieler() {
        int pos = players.indexOf(aktuellerSpieler);
        pos += reverse ? -1 : 1; 
        pos = pos % players.size();
        aktuellerSpieler = players.get(pos);
    }

    public UnoSpieler gewinnerVorhanden() {
        for (UnoSpieler player : players) {
            if (player.getHandkarten().getAnzahl() == 0) {
                return player;
            }
        }
        return null;
    }
}
