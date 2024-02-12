package archiv;
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

    /**
     * Legt die Karte k auf den Kartenstapel, die Karte wird passen auf den Stapel gelegt. 
     * Entweder aufgedeckt oder zu.
     * @param k
     */
    public void karteAuflegen(UnoKarte k) {
        k.setOffen(offen);
        karten.add(k);
    }

    public void kartenAuflegen(ArrayList<UnoKarte> karten){
        for(UnoKarte k: karten){
            k.setOffen(offen);
        }
        this.karten = karten;
    }

    public int getSize() {
        return karten.size();
    }

    public void shuffle() {
        Collections.shuffle(karten);
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
        for(int i = 0;i < anzahl; i++){
            UnoKarte k = karteZiehen();
            if (k == null){
                break;
            }
            ziehkarten.add(k);
        }
        return ziehkarten;
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