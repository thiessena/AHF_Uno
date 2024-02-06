import java.util.ArrayList;

public class UnoKarte {
    private String farbe;
    private int ziffer;
    private boolean offen;

    public UnoKarte(String pFarbe, int pZiffer) {
        this.farbe = pFarbe;
        this.ziffer = pZiffer;
    }

    public String getFarbe() {
        return farbe;
    }

    public int getZiffer() {
        return ziffer;
    }

    public boolean isOffen() {
        return offen;
    }

    public void setOffen(boolean offen) {
        this.offen = offen;
    }

    public String toString() {

        return offen ? "(" + farbe + "|" + ziffer + ")" : "(XXXX X)";
    }

    public String toNetString(){
        return "K["+farbe+"-"+ziffer+"-"+offen+"]";
    }

    /**
     * Gibt eine ArrayListe mit allen Karten zurück.
     * 
     * @return
     */
    public static ArrayList<UnoKarte> getUnoKartenSet() {
        ArrayList<UnoKarte> karten = new ArrayList<>();
        String[] farben = { "rot", "blau", "gelb", "grün" };
        // String[] sonderzeichen = { "Aussetzen", "Zwei ziehen", "Vier ziehen",
        // "Richtungswechsel", "Farbwechsel" };

        for (int f = 0; f < farben.length; f++) {
            for (int z = 0; z < 9; z++) {
                karten.add(new UnoKarte(farben[f], z));
            }
        }
        return karten;
    }
}
