
import java.util.ArrayList;

/**
 * Verwaltet die Handkarten
 */
public class Handkarten {
    ArrayList<Karte> karten = new ArrayList<Karte>();
    ArrayList<Karte> ausgewaehlteKarten = new ArrayList<Karte>();

    public void sortieren() {

    }

    /**
     * Gibt die Karte zurück, die an der Stelle index liegt. Die Karte wird von den
     * Handkarten entfernt.
     * 
     * @param index
     * @return
     */
    public Karte ziehen(int index) {
        Karte k = karten.get(index);
        karten.remove(index);
        return k;
    }

    public void karteAuswaehlen(int index) {
        if (!ausgewaehlteKarten.contains(karten.get(index))) {
            ausgewaehlteKarten.add(karten.get(index));
        }
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
    public void kartenAuswaehlen(ArrayList<Karte> karten) {
        ausgewaehlteKarten.removeAll(karten);
        ausgewaehlteKarten.addAll(karten);
    }

    public void alleKartenAbwaehlen() {
        ausgewaehlteKarten = new ArrayList<>();
    }

    public ArrayList<Karte> getAusgewaehlteKarten() {
        return ausgewaehlteKarten;
    }

    public int getAnzahl() {
        return karten.size();
    }

}
