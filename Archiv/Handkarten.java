
import java.util.ArrayList;

/**
 * Verwaltet die Handkarten
 */
public class Handkarten {
    ArrayList<UnoKarte> karten = new ArrayList<UnoKarte>();
    ArrayList<UnoKarte> ausgewaehlteKarten = new ArrayList<UnoKarte>();

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

    public void karteAuswaehlen(int index) {
        if (!ausgewaehlteKarten.contains(karten.get(index))) {
            ausgewaehlteKarten.add(karten.get(index));
        }
    }

    public UnoKarte getKarte(int nummer){
        return karten.get(nummer);
    }

    public void karteHinzufuegen(UnoKarte karte){
        karten.add(karte);
    }

    public void kartenHinzufuegen(ArrayList<UnoKarte> karten){
        karten.addAll(karten);
    }

    public void karteAbwaehlen(int index) {
        if (!ausgewaehlteKarten.contains(karten.get(index))) {
            ausgewaehlteKarten.remove(karten.get(index));
        }
    }

    /**
     * Wählt die Karten aus, die
     * 
     * @param karten
     */
    public void kartenAuswaehlen(ArrayList<UnoKarte> karten) {
        ausgewaehlteKarten.removeAll(karten);
        ausgewaehlteKarten.addAll(karten);
    }

    public void alleKartenAbwaehlen() {
        ausgewaehlteKarten = new ArrayList<>();
    }

    public ArrayList<UnoKarte> getAusgewaehlteKarten() {
        return ausgewaehlteKarten;
    }

    public ArrayList<UnoKarte> getKarten(){
        return karten;
    }

    public int getAnzahl() {
        return karten.size();
    }

}
