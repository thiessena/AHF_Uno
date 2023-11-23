import java.util.ArrayList;
import java.util.Arrays;

public class UNOHandkartenAnzeige {
    public static void main(String[] args) {
        ArrayList<String> handkarten = generateUNOHandkarten();
        
        System.out.println("Deine UNO Handkarten:");
        for (String karte : handkarten) {
            System.out.println(karte);
        }
    }
    
    public static ArrayList<String> generateUNOHandkarten() {
        ArrayList<String> handkarten = new ArrayList<>();
        
        // Farben
        ArrayList<String> farben = new ArrayList<>(Arrays.asList("Rot", "Blau", "Grün", "Gelb"));
        
        // Zahlenkarten
        for (String farbe : farben) {
            for (int zahl = 0; zahl <= 9; zahl++) {
                handkarten.add(farbe + " " + zahl);
            }
        }
        
        // Aktionskarten
        for (String farbe : farben) {
            handkarten.add(farbe + " Aussetzen");
            handkarten.add(farbe + " Ziehe Zwei");
            handkarten.add(farbe + " Richtungswechsel");
        }
        
        // Farbe wählen Karten
        for (int i = 0; i < 4; i++) {
            handkarten.add("Farbe wählen");
            handkarten.add("Farbe wählen + Vier ziehen");
        }
        
        return handkarten;
    }
}
