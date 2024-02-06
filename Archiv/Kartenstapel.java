import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kartenstapel {
    // Die erste Karte ist unten, die letzte Karte liegt oben.
    private List<UnoKarte> karten;

    public Kartenstapel() {
        karten = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(karten);
    }

    public void setKarten(ArrayList<UnoKarte> karten) {
        this.karten = karten;
    }

    public UnoKarte getObersteKarte(){
        return karten.get(0).isOffen() ? karten.get(0) : null;
    }

    public UnoKarte karteZiehen() {
        if (karten.isEmpty()) {
            return null;
            // Keine Karten mehr im Stapel
        }
        return karten.remove(karten.size() - 1);
    }

    public ArrayList<UnoKarte> kartenZiehen(int anzahl){
        ArrayList<UnoKarte> karten = new ArrayList<>(); 
        for(int i = 0; i < anzahl && i < karten.size(); i++){
            karten.add(karteZiehen());
        }
        return karten;
    }

    public void karteAuflegen(UnoKarte k) {
        karten.add(k);
    }

    public int getSize() {
        return karten.size();
    }

    // Methode, um zu überprüfen, ob die oberste Karte offen ist
    public boolean istObersteKarteOffen() {
        if (!karten.isEmpty()) {
            UnoKarte k = karten.get(karten.size() - 1);
            return k.isOffen();
        } else {
            System.out.println("Stapel ist leer.");
            return false; // Hier könntest du je nach Anforderungen auch eine Ausnahme werfen.
        }
    }

    /**
     * Gibt eine Textrepresentation des Kartenstapels zurück.
     */
    public String toString(){
        String text = ""; 
        if (karten.size() == 0) {
            return "-"; 
        }
        text += karten.get(0); 
        for(int i = 0; i < karten.size() && i < 4; i++){
            text+="|";
        }
        return text;
    }
}