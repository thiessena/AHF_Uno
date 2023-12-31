import java.util.ArrayList;
import java.util.Scanner;

public class Spiel {
    private Kartenstapel drawPile;
    private Kartenstapel discardPile;
    private ArrayList<Spieler> players;
    private Karte currentCard;
    private boolean reverse;
    private int aktuellerSpieler;

    public Spiel() {
        drawPile = new Kartenstapel();
        discardPile = new Kartenstapel();
        players = new ArrayList<>();
        reverse = false;
        aktuellerSpieler = 0;
    }

    public void start() {
        System.out.println("Das Spiel Uno beginnt!");

        // Initialisiere das Kartendeck
        drawPile.setKarten(Karte.getUnoKartenSet());

        // Mische das Kartendeck
        drawPile.shuffle();

        // Ziehe die erste Karte und lege sie auf den Ablagestapel
        currentCard = drawPile.karteZiehen();
        discardPile.karteAuflegen(currentCard);

        // Spiele solange, bis ein Spieler gewinnt
        while (!checkWin()) {
            Spieler aktuellerSpieler = players.get(currentPlayerIndex);
            System.out.println("Aktueller Spieler: " + aktuellerSpieler.getName());

            // Zeige die oberste Karte auf dem Ablagestapel an
            System.out.println("Aktuelle Karte: " + currentCard.getFarbe() + " " + currentCard.getZiffer());

            // Zeige die Handkarten des aktuellen Spielers an
            System.out.println("Deine Handkarten:");
            aktuellerSpieler.displayHand();

            // Frage den Spieler nach seinem Zug
            System.out.println("Welche Karte möchtest du spielen? (Gib die Position der Karte ein)");
            Scanner scanner = new Scanner(System.in);
            int cardIndex = scanner.nextInt();

            // Überprüfe, ob der Zug gültig ist
            Card selectedCard = aktuellerSpieler.playCard(cardIndex);
            if (isValidMove(selectedCard)) {
                // Lege die Karte auf den Ablagestapel
                discardPile.addCard(selectedCard);
                currentCard = selectedCard;

                // Überprüfe, ob der Spieler gewonnen hat
                if (aktuellerSpieler.getHandSize() == 0) {
                    System.out.println("Herzlichen Glückwunsch, " + aktuellerSpieler.getName() + "! Du hast gewonnen!");
                    break;
                }

                // Überprüfe, ob der Spieler eine Sonderkarte gespielt hat
                handleSpecialCard(selectedCard);

                // Wechsle zum nächsten Spieler
                changePlayer();
            } else {
                System.out.println("Ungültiger Zug! Bitte versuche es erneut.");
            }
        }

        System.out.println("Das Spiel Uno ist beendet.");
    }

    private boolean checkWin() {
        for (Player player : players) {
            if (player.getHandSize() == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidMove(Card card) {
        return card.getColor().equals(currentCard.getColor()) || card.getValue() == currentCard.getValue();
    }

    }

    private void changePlayer() {
        if (reverse) {
            currentPlayerIndex--;
            if (currentPlayerIndex < 0) {
                currentPlayerIndex = players.size() - 1;
            }
        } else {
            currentPlayerIndex++;
            if (currentPlayerIndex >= players.size()) {
                currentPlayerIndex = 0;
            }
        }
    }

    private Spieler getNextPlayer() {
        int nextPlayerIndex;
        if (reverse) {
            nextPlayerIndex = currentPlayerIndex - 1;
            if (nextPlayerIndex < 0) {
                nextPlayerIndex = players.size() - 1;
            }
        } else {
            nextPlayerIndex = currentPlayerIndex + 1;
            if (nextPlayerIndex >= players.size()) {
                nextPlayerIndex = 0;
            }
        }
        return players.get(nextPlayerIndex);
    }

    public static void main(String[] args) {
        System.out.println("Test");
    }
}
