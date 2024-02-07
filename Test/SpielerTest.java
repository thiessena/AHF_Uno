import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class UNOTest {

    @Test
    public void testStartGame() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Spieler 1"));
        players.add(new Player("Spieler 2"));
        players.add(new Player("Spieler 3"));
        players.add(new Player("Spieler 4"));

        // Call the method under test
        startGame(players);

        // Assert expected behavior
        // Add assertions to check if the game is started correctly
    }
}
