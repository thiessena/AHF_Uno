package archiv.test;
import archiv.Handkarten;
import archiv.UnoKarte;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class HandkartenTest {
    
    @Test
    public void testKarteHinzufuegen(){
        Handkarten hK = new Handkarten(); 
        UnoKarte uK = new UnoKarte("rot", 12);
        hK.karteHinzufuegen(uK);
        assertEquals(1, hK.getAnzahl());
        assertEquals(uK,hK.getKarte(0));


    }

    @Test
    public void testKartenHinzufuegen(){
        ArrayList<UnoKarte> karten = new ArrayList<>();
        int anzahl = 10;
        for(int i = 0; i < anzahl; i++){
            karten.add(new UnoKarte("blau", i+1));
        }
        Handkarten hK = new Handkarten(); 
        hK.kartenHinzufuegen(karten);
        assertEquals(anzahl, hK.getAnzahl());
        assertEquals(karten.get(3), hK.getKarte(3));
    }


}
