
import java.util.ArrayList;
import java.util.Scanner;

public class Spiel {
    private Kartenstapel nachZiehStapel;
    private Kartenstapel ablageStapel;
    private ArrayList<UnoSpieler> players;
    private boolean reverse;
    private UnoSpieler aktuellerSpieler;
    private KonsolenView kView;

    public Spiel(KonsolenView kView) {
        nachZiehStapel = new Kartenstapel();
        ablageStapel = new Kartenstapel();
        players = new ArrayList<>();
        reverse = false;
        aktuellerSpieler = null;
        this.kView = kView;
    }

    public void addSpieler(UnoSpieler uSpieler){
        players.add(uSpieler);
    }

    public UnoSpieler getAktuellerSpieler(){
        return aktuellerSpieler;
    }

    public Kartenstapel getAblagestapel(){
        return ablageStapel; 
    }

    public Kartenstapel getNachZiehstapel(){
        return nachZiehStapel;
    }

    public void start() {
        // Initialisiere das Kartendeck
        nachZiehStapel.setKarten(UnoKarte.getUnoKartenSet());
        // Mische das Kartendeck
        nachZiehStapel.shuffle();
        // Ziehe die erste Karte und lege sie auf den Ablagestapel
        ablageStapel.karteAuflegen(nachZiehStapel.karteZiehen());
        //Mache den ersten Spieler zum aktuellen Spieler
        aktuellerSpieler = players.get(0);
        //Spielern die Handkarten geben
        for(UnoSpieler spieler : players){
            spieler.getHandkarten().kartenHinzufuegen(nachZiehStapel.kartenZiehen(5));
        }
    }

    public boolean karteSpielen(int kartenNummer){
        UnoKarte karte = aktuellerSpieler.getHandkarten().getKarte(kartenNummer); 
        if(erlaubteKarte(karte)){
            karte = aktuellerSpieler.getHandkarten().ziehen(kartenNummer);
            ablageStapel.karteAuflegen(karte);
            naechsteSpieler();
            return true;
        }
        return false;
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

    public void naechsteSpieler() {
        int pos = players.indexOf(aktuellerSpieler);
        pos = reverse ? pos -1 : pos + 1; 
        if(pos < 0){
            aktuellerSpieler = players.get(players.size()-1);
        }else{
            aktuellerSpieler = players.get(pos);
        }
    }

    public boolean gewinnerVorhanden() {
        for (UnoSpieler player : players) {
            if (player.getHandkarten().getAnzahl() == 0) {
                return true;
            }
        }
        return false;
    }
}
