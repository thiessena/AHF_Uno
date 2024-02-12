package archiv;
import java.util.ArrayList;

/**
 * Verwaltet die Handkarten
 */
public class Handkarten {
    private ArrayList<UnoKarte> karten;

    public Handkarten(){
        karten = new ArrayList<UnoKarte>();
    }

    /**
     * Erstellt Handkarten aus einer ArrayList
     * @param karten
     */
    public Handkarten(ArrayList<UnoKarte> karten){
        this.karten = karten;
    }

    /**
     * Gibt die Handkarten als ArrayList zurück.
     * @return
     */
    public ArrayList<UnoKarte> getKarten(){
        return karten;
    }

    /**
     * Gibt die Anzahl der Karten in der Hand zurück.
     * @return
     */
    public int getAnzahl() {
        return karten.size();
    }

    public void sortieren() {

    }

    /**
     * Gibt die Karte zurück, die an der Stelle index liegt. Die Karte wird von den
     * Handkarten entfernt.
     * 
     * @param index
     * @return
     */
    public UnoKarte ziehen(int index) {
        UnoKarte k = karten.get(index);
        karten.remove(index);
        return k;
    }

    /**
     * Gibt die Karte an der Position nummer zurück.
     * @param nummer
     * @return
     */
    public UnoKarte getKarte(int nummer){
        return karten.get(nummer);
    }

    /**
     * Fügt eine offene Karte ganz hinten an die Karte hinzu.
     * @param karte
     */
    public void karteHinzufuegen(UnoKarte karte){
        karte.setOffen(true);
        karten.add(karte);
    }

    /**
     * Fügt eine ArrayListe von Karten zur Hand hinzu.
     * @param karten
     */
    public void kartenHinzufuegen(ArrayList<UnoKarte> karten){
        for( UnoKarte k: karten){
            k.setOffen(true);
            this.karten.add(k);
        }
    }

    /**
     * Gibt einen String der Handkarten zurück.
     */
    public String toString(){
        String text = "Handkarten:   "; 
        for(UnoKarte k: karten){
            text += "  " + k.toString() ; 
        }
        return text;
    }
}
