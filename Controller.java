import java.util.List;

public class UnoController {
    private UnoModel model;
    private UnoView view;

    public UnoController(UnoModel model, UnoView view) {
        this.model = model;
        this.view = view;

        // Fügen Sie hier die ActionListener für die Interaktionselemente der Ansicht hinzu
        view.addDrawCardListener(e -> drawCard());
        view.addPlayCardListener(e -> playCard());

        // Initialisieren Sie das Spiel
        model.initializeGame();
        updateView();
    }

    public void drawCard() {
        model.drawCard();
        updateView();
    }

    public void playCard() {
        // Hier können Sie die Logik für das Spielen einer Karte implementieren
        // Rufen Sie die entsprechenden Methoden im Modell auf, um die Karte zu spielen
        // und aktualisieren Sie die Ansicht entsprechend
    }

    private void updateView() {
        // Aktualisieren Sie die Ansicht, um den aktuellen Zustand des Spiels anzuzeigen
        List<Card> playerHand = model.getPlayerHand();
        List<Card> playedCards = model.getPlayedCards();
        view.updatePlayerHand(playerHand);
        view.updatePlayedCards(playedCards);
    }

    public static void main(String[] args) {
        UnoModel model = new UnoModel();
        UnoView view = new UnoView();
        UnoController controller = new UnoController(model, view);
        view.setVisible(true);
    }
}


/**
Dokumentation:

@startuml

class UnoController {
    - model: UnoModel
    - view: UnoView

    + UnoController(model: UnoModel, view: UnoView)
    + drawCard(): void
    + playCard(): void
    - updateView(): void
    + main(args: String[]): void
}

UnoController -- UnoModel
UnoController -- UnoView

@enduml
Diese Dokumentation zeigt die Struktur der Klasse "UnoController" mit ihren Attributen und Methoden. Die Assoziationen zu den Klassen "UnoModel" und "UnoView" werden ebenfalls dargestellt.
*/
