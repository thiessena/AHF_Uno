package archiv.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import archiv.Spiel;
import archiv.UnoSpieler;
import java.util.ArrayList;

public class SpielTest {
    
    @Test
    public void naechsteSpielerTest(){
        Spiel s = Spiel.getDefaultSpiel(null);
        ArrayList<UnoSpieler> spieler = s.getAlleSpieler();
        s.naechsteSpieler();
        assertEquals(spieler.get(1),s.getAktuellerSpieler());
        s.naechsteSpieler();
        assertEquals(spieler.get(0),s.getAktuellerSpieler());
        s.naechsteSpieler();
        assertEquals(spieler.get(1),s.getAktuellerSpieler());
    }
}
