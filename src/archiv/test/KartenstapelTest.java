package archiv.test;

import archiv.Kartenstapel;
import archiv.UnoKarte;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class KartenstapelTest {
    @Test
    public void karteAuflegenTest(){
        UnoKarte uK = new UnoKarte("rot", 3); 
        Kartenstapel kStapel = new Kartenstapel(true);
        kStapel.karteAuflegen(uK);
        assertEquals(1,kStapel.getSize());
    }

    @Test
    public void getObersteKarteTest(){
        UnoKarte uK = new UnoKarte("rot", 3); 
        Kartenstapel kStapel = new Kartenstapel(true);
        kStapel.karteAuflegen(uK);
        assertEquals(uK, kStapel.getObersteKarte());
    }

    @Test
    public void karteZiehenTest(){
        UnoKarte uK = new UnoKarte("rot", 3); 
        Kartenstapel kStapel = new Kartenstapel(true);
        kStapel.karteAuflegen(uK);
        assertEquals(1,kStapel.getSize());
        UnoKarte gezogeneKarte = kStapel.karteZiehen();
        assertEquals(0,kStapel.getSize());
        assertEquals(uK, gezogeneKarte);
    }

    @Test
    public void kartenZiehenTest(){
        ArrayList<UnoKarte> karten =new ArrayList<>(); 
        int anzahl = 12;
        for (int i = 0; i < anzahl; i++){
            karten.add(new UnoKarte("rot", i));
        } 
        Kartenstapel kStapel = new Kartenstapel(true);
        kStapel.kartenAuflegen(karten);
        assertEquals(anzahl,kStapel.getSize());
        ArrayList<UnoKarte> gezogeneKarten = kStapel.kartenZiehen(anzahl);
        assertEquals(0,kStapel.getSize());
        assertEquals(anzahl, gezogeneKarten.size());
    }
}
