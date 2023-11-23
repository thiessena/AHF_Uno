/**
 * Die Klasse "BenutzerPool" verwaltet eine Liste von Spielern für das Spiel Uno.
 */
public class BenutzerPool {
    private ArrayList<Spieler> benutzer;

    /**
     * Konstruktor für die Klasse "BenutzerPool".
     * Erzeugt eine leere Liste von Spielern.
     */
    public BenutzerPool() {
        benutzer = new ArrayList<>();
    }

    /**
     * Fügt einen Spieler zur Liste hinzu.
     *
     * @param spieler Der Spieler, der hinzugefügt werden soll.
     */
    public void addBenutzer(Spieler spieler) {
        benutzer.add(spieler);
    }

    /**
     * Entfernt einen Spieler aus der Liste.
     *
     * @param spieler Der Spieler, der entfernt werden soll.
     */
    public void removeBenutzer(Spieler spieler) {
        benutzer.remove(spieler);
    }

    /**
     * Gibt die Liste der Spieler aus.
     */
    public void printBenutzer() {
        System.out.println("Benutzerliste:");
        for (Spieler spieler : benutzer) {
            System.out.println(spieler.getName());
        }
    }

    /**
     * Hauptmethode zum Testen der Klasse "BenutzerPool".
     *
     * @param args Die Eingabeparameter (nicht verwendet).
     */
    public static void main(String[] args) {
        BenutzerPool benutzerPool = new BenutzerPool();

        Spieler spieler1 = new Spieler("Benutzer1");
        Spieler spieler2 = new Spieler("Benutzer2");
        Spieler spieler3 = new Spieler("Benutzer3");

        benutzerPool.addBenutzer(spieler1);
        benutzerPool.addBenutzer(spieler2);
        benutzerPool.addBenutzer(spieler3);

        benutzerPool.printBenutzer();

        benutzerPool.removeBenutzer(spieler2);

        benutzerPool.printBenutzer();
    }
}

