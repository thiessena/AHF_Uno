package archiv;
import java.util.Scanner;

public class KonsolenView{
    Spiel spiel;
    Scanner eingabe = new Scanner(System.in);

    public KonsolenView(Spiel pSpiel){
        spiel = pSpiel; 
        game();
    }

    public void start(){
        System.out.println(" =========================[ U N O ]=====================");
        System.out.println("= Wie viele Spieler spielen mit?"); 
        int anzahlSpieler = eingabe.nextInt();
        for(int i = 0; i < anzahlSpieler; i++){
            System.out.print("= Wie soll der " + (i+1) + ". Spieler heißen? ");
            String name = eingabe.next();
            spiel.addSpieler(new UnoSpieler(name));
        }
        System.out.println("= Das Spiel Uno beginnt!");
        System.out.println();
    }

    public void showSpiel(){
        System.out.println(" ====[Spieler:" + spiel.getAktuellerSpieler().getBenutzername() + "]===========================");
        System.out.print("= Deine Handkarten:"); 
        Handkarten hK = spiel.getAktuellerSpieler().getHandkarten();
        for(UnoKarte k: hK.getKarten()){
            System.out.print(k.toString()+" ");
        }

        System.out.println();
        Kartenstapel aStapel = spiel.getAblagestapel();
        Kartenstapel nStapel = spiel.getNachZiehstapel();
        System.out.println("= __" + aStapel.toString() + "__\t| Nachziehstapel:" + nStapel.toString());
        System.out.println();
    }

    public void spielzug(){
        if(!spiel.moeglicheKarten()){
            System.out.println("= ! Du kannst nichts legen") ;
            spiel.spielerZiehtKarte();
            return;
        }
        
        System.out.print("= Gib die Nummer der Handkarte (von links)ein: ");
        int kartenNummer = eingabe.nextInt(); 
        if(!spiel.karteSpielen(kartenNummer-1)){
            System.out.println("= ! Diese Karte kann nicht gelegt werden");
            return;
        }
    }

    public void siegerAngeben(){
        System.out.println("= ! Der Spieler " + spiel.gewinnerVorhanden().getBenutzername() + " hat gewonnen."); 
        System.out.println("= ! Die anderen Spieler haben noch Karten:"); 
    }

    public void game(){
        start();
        spiel.start();
        while(spiel.gewinnerVorhanden() == null){
            showSpiel();
            spielzug();
            spiel.naechsteSpieler();
        }
        siegerAngeben();
    }

    public static void main(String[] args){
        Spiel spiel = new Spiel();
        new KonsolenView(spiel);

    }
}