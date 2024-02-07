import org.junit.Test;
import static org.junit.Assert.*;

public class BenutzerPoolTest {

    @Test
    public void testAddBenutzer() {
        BenutzerPool benutzerPool = new BenutzerPool();
        Spieler spieler = new Spieler("Benutzer1");

        benutzerPool.addBenutzer(spieler);

        assertEquals(1, benutzerPool.getBenutzer().size());
        assertTrue(benutzerPool.getBenutzer().contains(spieler));
    }

    @Test
    public void testRemoveBenutzer() {
        BenutzerPool benutzerPool = new BenutzerPool();
        Spieler spieler1 = new Spieler("Benutzer1");
        Spieler spieler2 = new Spieler("Benutzer2");

        benutzerPool.addBenutzer(spieler1);
        benutzerPool.addBenutzer(spieler2);

        benutzerPool.removeBenutzer(spieler1);

        assertEquals(1, benutzerPool.getBenutzer().size());
        assertFalse(benutzerPool.getBenutzer().contains(spieler1));
        assertTrue(benutzerPool.getBenutzer().contains(spieler2));
    }
}