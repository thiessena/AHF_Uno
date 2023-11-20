import java.util.ArrayList;
import java.util.List;

public class UNO {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        
        // Spieler erstellen und zur Spielerliste hinzufügen
        players.add(new Player("Spieler 1"));
        players.add(new Player("Spieler 2"));
        players.add(new Player("Spieler 3"));
        players.add(new Player("Spieler 4"));
        
        // Spiel starten
        startGame(players);
    }
    
    public static void startGame(List<Player> players) {
        // Spiellogik hier implementieren
    }
}

class Player {
    private String name;
    
    public Player(String name) {
        this.name = name;
    }
    
    // Weitere Methoden und Eigenschaften des Spielers hier implementieren
}
