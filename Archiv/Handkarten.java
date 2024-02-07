
import java.util.ArrayList;

/**
 * Verwaltet die Handkarten
 */
public class Handkarten {
    private ArrayList<UnoKarte> karten;

    public Handkarten(){
        karten = new ArrayList<UnoKarte>();
    }

    public Handkarten(ArrayList<UnoKarte> karten){
        this.karten = karten;
    }

    public ArrayList<UnoKarte> getKarten(){
        return karten;
    }

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

    public UnoKarte getKarte(int nummer){
        return karten.get(nummer);
    }

    public void karteHinzufuegen(UnoKarte karte){
        karte.setOffen(true);
        karten.add(karte);
    }

    public void kartenHinzufuegen(ArrayList<UnoKarte> karten){
        for( UnoKarte k: karten){
            k.setOffen(true);
            this.karten.add(k);
        }
    }

    public String toString(){
        String text = "Handkarten:   "; 
        for(UnoKarte k: karten){
            text += "  " + k.toString() ; 
        }
        return text;
    }
}
