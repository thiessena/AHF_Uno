package archiv;
import java.util.ArrayList;

/**
 * Die Klasse {@code BenutzerPool} repräsentiert einen Pool von Benutzern
 * (Spieler) für das Uno-Spiel.
 * Benutzer können hinzugefügt, entfernt und angezeigt werden. Zusätzlich können
 * Benutzer nach ihrem Namen,
 * ihrer IP-Adresse und Portnummer gesucht werden, und es kann eine Liste aller
 * Benutzer abgerufen werden.
 */
public class BenutzerPool {
    private ArrayList<UnoSpieler> benutzer;

    /**
     * Konstruktor für die {@code BenutzerPool}-Klasse. Initialisiert die interne
     * Liste der Benutzer.
     */
    public BenutzerPool() {
        benutzer = new ArrayList<>();
    }

    /**
     * Fügt einen Benutzer (Spieler) zum Pool hinzu.
     *
     * @param spieler Der hinzuzufügende Spieler.
     */
    public void addBenutzer(UnoSpieler spieler) {
        benutzer.add(spieler);
    }

    /**
     * Entfernt einen Benutzer (Spieler) aus dem Pool.
     *
     * @param spieler Der zu entfernende Spieler.
     */
    public void removeBenutzer(UnoSpieler spieler) {
        benutzer.remove(spieler);
    }

    /**
     * Gibt alle Benutzer im Pool aus.
     */
    public void printBenutzer() {
        System.out.println("Benutzerliste:");
        for (UnoSpieler spieler : benutzer) {
            System.out.println(spieler.getBenutzername());
        }
    }

    /**
     * Sucht nach einem Benutzer mit einem bestimmten Namen.
     *
     * @param name Der Name des gesuchten Benutzers.
     * @return Der gefundene Spieler oder {@code null}, wenn kein Spieler mit dem
     *         angegebenen Namen gefunden wurde.
     */
    public UnoSpieler gibSpielerMitName(String name) {
        for (UnoSpieler spieler : benutzer) {
            if (spieler.getBenutzername().equals(name)) {
                return spieler;
            }
        }
        return null;
    }

    /**
     * Sucht nach einem Benutzer mit einer bestimmten IP-Adresse und Portnummer.
     *
     * @param ipPort Die IP-Adresse und Portnummer des gesuchten Benutzers.
     * @return Der gefundene Spieler oder {@code null}, wenn kein Spieler mit der
     *         angegebenen IP-Adresse und Portnummer gefunden wurde.
     */
    public UnoSpieler gibSpielerMitIPPort(String ipPort) {
        for (UnoSpieler spieler : benutzer) {
            if (spieler.getIPPort().equals(ipPort)) {
                return spieler;
            }
        }
        return null;
    }

    /**
     * Gibt eine ArrayList mit allen Benutzern im Pool zurück.
     *
     * @return Eine ArrayList mit allen Benutzern im Pool.
     */
    public ArrayList<UnoSpieler> gibAlleSpieler() {
        return benutzer;
    }
}