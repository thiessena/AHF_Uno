import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kartenstapel {
    // Die erste Karte ist unten, die letzte Karte liegt oben.
    private List<UnoKarte> karten;
    private boolean offen;

    public Kartenstapel(boolean offen) {
        karten = new ArrayList<>();
        this.offen = offen;
    }

    public void shuffle() {
        Collections.shuffle(karten);
    }

    public void setKarten(ArrayList<UnoKarte> karten) {
        this.karten = karten;
    }

    public UnoKarte getObersteKarte(){
        UnoKarte k = karten.get(karten.size() - 1); 
        k.setOffen(offen);
        return k;
    }

    public UnoKarte karteZiehen() {
        if (karten.size() == 0) {
            return null;
        }
        UnoKarte k = karten.get(karten.size()-1);
        karten.remove(karten.size() - 1);
        return k;
    }

    public ArrayList<UnoKarte> kartenZiehen(int anzahl){
        ArrayList<UnoKarte> ziehkarten = new ArrayList<>(); 
        for(int i = 0; i < anzahl && i < karten.size(); i++){
            ziehkarten.add(karteZiehen());
        }
        return ziehkarten;
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
        
        text += karten.get(karten.size()-1).toString(); 
        for(int i = 0; i < karten.size() && i < 3; i++){
            text+="|";
        }
        return text + karten.size()+"|";
    }
}