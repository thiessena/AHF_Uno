import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kartenstapel {
    private List<Karte> cards;

    public Kartenstapel() {
        cards = new ArrayList<>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void setKarten(ArrayList<Karte> karten) {
        cards = karten;
    }

    public Karte karteZiehen() {
        if (cards.isEmpty()) {
            return null;
            // Keine Karten mehr im Stapel
        }
        return cards.remove(cards.size() - 1);
    }

    public void karteAuflegen(Karte k) {
        // toDo;
    }

    public int getSize() {
        return cards.size();
    }

    // Methode, um zu überprüfen, ob die oberste Karte offen ist
    public boolean istObersteKarteOffen() {
        if (!cards.isEmpty()) {
            return cards.get(cards.size() - 1).isOffen();
        } else {
            System.out.println("Stapel ist leer.");
            return false; // Hier könntest du je nach Anforderungen auch eine Ausnahme werfen.
        }
    }
}

// Diese Klasse verwendet eine andere Klasse Karten, die die einzelnen Karten
// repräsentiert.
// überprüfen: ist oberste karte zu sehen oder umgedreht
// Karte auf stapel legen
