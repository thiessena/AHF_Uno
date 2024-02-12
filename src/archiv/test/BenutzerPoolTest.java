package archiv.test;
import org.junit.Test;

import archiv.BenutzerPool;
import archiv.UnoSpieler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BenutzerPoolTest {

    @Test
    public void testAddBenutzer() {
        BenutzerPool benutzerPool = new BenutzerPool();
        UnoSpieler spieler = new UnoSpieler("Benutzer1");

        benutzerPool.addBenutzer(spieler);

        assertEquals(1, benutzerPool.gibAlleSpieler().size());
        assertTrue(benutzerPool.gibAlleSpieler().contains(spieler));
    }

    @Test
    public void testRemoveBenutzer() {
        BenutzerPool benutzerPool = new BenutzerPool();
        UnoSpieler spieler1 = new UnoSpieler("Benutzer1");
        UnoSpieler spieler2 = new UnoSpieler("Benutzer2");

        benutzerPool.addBenutzer(spieler1);
        benutzerPool.addBenutzer(spieler2);

        benutzerPool.removeBenutzer(spieler1);

        assertEquals(1, benutzerPool.gibAlleSpieler().size());
        assertFalse(benutzerPool.gibAlleSpieler().contains(spieler1));
        assertTrue(benutzerPool.gibAlleSpieler().contains(spieler2));
    }
}