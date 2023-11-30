/**
 * Die Klasse "BenutzerPool" verwaltet eine Liste von Spielern für das Spiel Uno.
 
public class BenutzerPool {
    private ArrayList<Spieler> benutzer;

    /**
     * Konstruktor für die Klasse "BenutzerPool".
     * Erzeugt eine leere Liste von Spielern.
     
    public BenutzerPool() {
        benutzer = new ArrayList<>();
    }

    /**
     * Fügt einen Spieler zur Liste hinzu.
     *
     * @param spieler Der Spieler, der hinzugefügt werden soll.
     
    public void addBenutzer(Spieler spieler) {
        benutzer.add(spieler);
    }

    /**
     * Entfernt einen Spieler aus der Liste.
     *
     * @param spieler Der Spieler, der entfernt werden soll.
     
    public void removeBenutzer(Spieler spieler) {
        benutzer.remove(spieler);
    }

    /**
     * Gibt die Liste der Spieler aus.
     
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
}*/
import java.util.ArrayList;

/**
 * Die Klasse {@code BenutzerPool} repräsentiert einen Pool von Benutzern (Spieler) für das Uno-Spiel.
 * Benutzer können hinzugefügt, entfernt und angezeigt werden. Zusätzlich können Benutzer nach ihrem Namen,
 * ihrer IP-Adresse und Portnummer gesucht werden, und es kann eine Liste aller Benutzer abgerufen werden.
 */
public class BenutzerPool {
    private ArrayList<Spieler> benutzer;

    /**
     * Konstruktor für die {@code BenutzerPool}-Klasse. Initialisiert die interne Liste der Benutzer.
     */
    public BenutzerPool() {
        benutzer = new ArrayList<>();
    }

    /**
     * Fügt einen Benutzer (Spieler) zum Pool hinzu.
     *
     * @param spieler Der hinzuzufügende Spieler.
     */
    public void addBenutzer(Spieler spieler) {
        benutzer.add(spieler);
    }

    /**
     * Entfernt einen Benutzer (Spieler) aus dem Pool.
     *
     * @param spieler Der zu entfernende Spieler.
     */
    public void removeBenutzer(Spieler spieler) {
        benutzer.remove(spieler);
    }

    /**
     * Gibt alle Benutzer im Pool aus.
     */
    public void printBenutzer() {
        System.out.println("Benutzerliste:");
        for (Spieler spieler : benutzer) {
            System.out.println(spieler.getName());
        }
    }

    /**
     * Sucht nach einem Benutzer mit einem bestimmten Namen.
     *
     * @param name Der Name des gesuchten Benutzers.
     * @return Der gefundene Spieler oder {@code null}, wenn kein Spieler mit dem angegebenen Namen gefunden wurde.
     */
    public Spieler gibSpielerMitName(String name) {
        for (Spieler spieler : benutzer) {
            if (spieler.getName().equals(name)) {
                return spieler;
            }
        }
        return null;
    }

    /**
     * Sucht nach einem Benutzer mit einer bestimmten IP-Adresse und Portnummer.
     *
     * @param ipPort Die IP-Adresse und Portnummer des gesuchten Benutzers.
     * @return Der gefundene Spieler oder {@code null}, wenn kein Spieler mit der angegebenen IP-Adresse und Portnummer gefunden wurde.
     */
    public Spieler gibSpielerMitIPPort(String ipPort) {
        for (Spieler spieler : benutzer) {
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
    public ArrayList<Spieler> gibAlleSpieler() {
        return benutzer;
    }

    /**
     * Hauptmethode zum Testen der BenutzerPool-Klasse.
     *
     * @param args Die Befehlszeilenargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        // Testcode hier einfügen...
    }
}

/**
 * Die Klasse {@code Spieler} repräsentiert einen Spieler im Uno-Spiel.
 * Jeder Spieler hat einen Namen und eine IP-Adresse mit Portnummer.
 */
class Spieler {
    private String name;
    private String ipPort;

    /**
     * Konstruktor für die {@code Spieler}-Klasse. Initialisiert den Spieler mit einem Namen und einer IP-Adresse mit Portnummer.
     *
     * @param name   Der Name des Spielers.
     * @param ipPort Die IP-Adresse und Portnummer des Spielers.
     */
    public Spieler(String name, String ipPort) {
        this.name = name;
        this.ipPort = ipPort;
    }

    /**
     * Gibt den Namen des Spielers zurück.
     *
     * @return Der Name des Spielers.
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt die IP-Adresse mit Portnummer des Spielers zurück.
     *
     * @return Die IP-Adresse mit Portnummer des Spielers.
     */
    public String getIPPort() {
        return ipPort;
    }
}

