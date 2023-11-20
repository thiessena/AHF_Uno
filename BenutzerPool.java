/*Ich möchte eine klasse für uno in der die benutzer anhand einer arraylist angegeben werden.
Änder die Klasse so dass: 1) Die Klasse soll BenutzerPool heißen. 2) In der ArrayList sollen Objekte vom Typ Spieler verwaltet werden.*/
import java.util.ArrayList;

public class BenutzerPool {
    private ArrayList<Spieler> benutzer;

    public BenutzerPool() {
        benutzer = new ArrayList<>();
    }

    public void addBenutzer(Spieler spieler) {
        benutzer.add(spieler);
    }

    public void removeBenutzer(Spieler spieler) {
        benutzer.remove(spieler);
    }

    public void printBenutzer() {
        System.out.println("Benutzerliste:");
        for (Spieler spieler : benutzer) {
            System.out.println(spieler.getName());
        }
    }

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





Dokumentation:

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

/**
 * Die Klasse "Spieler" repräsentiert einen Spieler im Uno-Spiel.
 */
class Spieler {
    private String name;

    /**
     * Konstruktor für die Klasse "Spieler".
     *
     * @param name Der Name des Spielers.
     */
    public Spieler(String name) {
        this.name = name;
    }

    /**
     * Gibt den Namen des Spielers zurück.
     *
     * @return Der Name des Spielers.
     */
    public String getName() {
        return name;
    }
}

class Spieler {
    private String name;

    public Spieler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
