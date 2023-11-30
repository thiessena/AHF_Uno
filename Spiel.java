import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Deck drawPile;
    private Deck discardPile;
    private ArrayList<Player> players;
    private Card currentCard;
    private boolean reverse;
    private int currentPlayerIndex;

    public Game(String[] playerNames) {
        drawPile = new Deck();
        discardPile = new Deck();
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        reverse = false;
        currentPlayerIndex = 0;
    }

    public void start() {
        System.out.println("Das Spiel Uno beginnt!");

        // Initialisiere das Kartendeck
        drawPile.initializeDeck();

        // Mische das Kartendeck
        drawPile.shuffle();

        // Ziehe die erste Karte und lege sie auf den Ablagestapel
        currentCard = drawPile.drawCard();
        discardPile.addCard(currentCard);

        // Spiele solange, bis ein Spieler gewinnt
        while (!checkWin()) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("Aktueller Spieler: " + currentPlayer.getName());

            // Zeige die oberste Karte auf dem Ablagestapel an
            System.out.println("Aktuelle Karte: " + currentCard.getColor() + " " + currentCard.getValue());

            // Zeige die Handkarten des aktuellen Spielers an
            System.out.println("Deine Handkarten:");
            currentPlayer.displayHand();

            // Frage den Spieler nach seinem Zug
            System.out.println("Welche Karte möchtest du spielen? (Gib die Position der Karte ein)");
            Scanner scanner = new Scanner(System.in);
            int cardIndex = scanner.nextInt();

            // Überprüfe, ob der Zug gültig ist
            Card selectedCard = currentPlayer.playCard(cardIndex);
            if (isValidMove(selectedCard)) {
                // Lege die Karte auf den Ablagestapel
                discardPile.addCard(selectedCard);
                currentCard = selectedCard;

                // Überprüfe, ob der Spieler gewonnen hat
                if (currentPlayer.getHandSize() == 0) {
                    System.out.println("Herzlichen Glückwunsch, " + currentPlayer.getName() + "! Du hast gewonnen!");
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

    private Player getNextPlayer() {
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
}
