import java.util.ArrayList;

public class Karte {
    private String farbe;
    private int ziffer;

    public Karte(String pFarbe, int pZiffer) {

    }

    public String getFarbe() {
        return farbe;
    }

    public int getZiffer() {
        return ziffer;
    }

    /**
     * Gibt eine ArrayListe mit allen Karten zurück.
     * 
     * @return
     */
    public static ArrayList<Karte> getKartenSet() {
        ArrayList<Karte> karten = new ArrayList<>();
        String[] farben = { "rot", "blau", "gelb", "grün" };
        String[] sonderzeichen = { "Aussetzen", "Zwei ziehen", "Vier ziehen", "Richtungswechsel", "Farbwechsel" };

        for (int f = 0; f < farben.length; f++) {
            for (int z = 0; z < 9; z++) {
                karten.add(new Karte(farben[f], z));
            }
        }
        return karten;
    }
}
