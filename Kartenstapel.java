import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kartenstapel {
    private List<Karte> cards;

    public Kartenstapel() {
        cards = new ArrayList<>();
        // Erstelle alle Karten im Uno-Deck

        // Mische die Karten
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Karten drawCard() {
        if (cards.isEmpty()) {
            return null;
            // Keine Karten mehr im Stapel
        }
        return cards.remove(cards.size() - 1);
    }

    public int getSize() {
        return cards.size();
    }

    // Methode, um zu überprüfen, ob die oberste Karte offen ist
    public boolean istObersteKarteOffen() {
        if (obersteKarteIndex >= 0 && obersteKarteIndex < Kartenstapel.length) {
            return Kartenstapel[obersteKarteIndex].istOffen();
        } else {
            System.out.println("Stapel ist leer oder ungültiger Index.");
            return false; // Hier könntest du je nach Anforderungen auch eine Ausnahme werfen.
        }
    }

}

// Diese Klasse verwendet eine andere Klasse Karten, die die einzelnen Karten
// repräsentiert.
// überprüfen: ist oberste karte zu sehen oder umgedreht
// Karte auf stapel legen
