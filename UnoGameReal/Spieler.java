import java.util.ArrayList;
import java.util.List;

public class Spieler {

    public ArrayList<Karte> kartenStapel = new ArrayList<Karte>();

    public void kartenStapelDefinieren() {
        for (int i = 0; i < 10; i++) {
            kartenStapel.add(new Karte("rot", i));
        }
        for (int i = 0; i < 10; i++) {
            kartenStapel.add(new Karte("blau", i));
        }
        for (int i = 0; i < 10; i++) {
            kartenStapel.add(new Karte("grün", i));
        }
        for (int i = 0; i < 10; i++) {
            kartenStapel.add(new Karte("gelb", i));
        }
    }

    public void KarteSpielen() {
        // if()
    }

    public void getKarte() {
        for (int i = 0; i < 40; i++) {
            System.out.println(kartenStapel.get(i).getZiffer());
        }
    }

    public static void main(String[] args) {
        Spieler sp = new Spieler();
        sp.getKarte();
    }

}