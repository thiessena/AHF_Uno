
// hier sollten die allgemeinen Spieloperatoren angegeben werden
import java.util.Random;
import java.util.Stack;

public class MainGame {
    Random rand = new Random();
    private String[] randomFarbe = { "y", "b", "g", "r" };
    public Stack<Karte> stapel = new Stack<Karte>();
    public GUI gmui;

    public Karte abgelegteKarte;

    public MainGame() {

        GUI gameUI = new GUI(this);
        gmui = gameUI;
        gmui.setVisible(true);
        while (stapel.size() < 80) {
            Karte k = new Karte(randomFarbe[rand.nextInt(4)].toString(), rand.nextInt(10));
            if (!gibtKarte(2, k, stapel)) {
                stapel.push(k);
            }
        }

        abgelegteKarte = randomKarte();

        gmui.setAbgelegteKarte(abgelegteKarte);
        gmui.setNewHandkarte(stapel.pop());

    }

    public void initNewKarte() {
        if(stapel.empty()){
            while (stapel.size() < 80) {
                Karte k = new Karte(randomFarbe[rand.nextInt(4)].toString(), rand.nextInt(10));
                if (!gibtKarte(2, k, stapel)) {
                    stapel.push(k);
                }
            }
        }
        gmui.setNewHandkarte(stapel.pop());
    }

    public Stack<Karte> gibKartenAus() {
        return stapel;
    }

    public Karte randomKarte() {
        Karte k = new Karte(randomFarbe[rand.nextInt(4)].toString(), rand.nextInt(10));
        return k;
    }

    public boolean gibtKarte(int anzahl, Karte k, Stack<Karte> st) {
        boolean gibtEs = false;
        int i = 0;
        Stack<Karte> temp = new Stack<Karte>();
        while (!st.empty()) {
            if (k.getFarbe() == st.peek().getFarbe() && k.getZiffer() == st.peek().getZiffer()) {
                i++;
                temp.add(st.pop());
            } else {
                temp.add(st.pop());
            }
        }
        if (i >= anzahl) {
            gibtEs = true;
        } else {
            gibtEs = false;
        }

        while (!temp.empty()) {
            st.add(temp.pop());
        }

        return gibtEs;
    }

    public boolean alleKarten(Stack<Karte> stp) {
        boolean endErgebnis = false;
        if (stp.size() >= 80) {
            endErgebnis = true;
        }
        return endErgebnis;
    }

    /*
     * public boolean darfLegen(){
     * return Spieler.getKarte().darfauf();
     * }
     */

    public static void main(String[] args) {
        MainGame mG = new MainGame();
    }
}

// der "Ablagestapel" soll lediglich eine Karte sein die oben angezeigt und
// gegetted werden muss
// Der "Ziehstapel" soll eine Liste sein die vorher random preperiert wurde,
// hier wird die oberste Karte gezogen wenn der Spieler sie zieht
// weitere Regeln
