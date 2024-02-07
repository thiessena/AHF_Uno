import java.util.Scanner;

public class KonsolenView{
    Spiel spiel;
    Scanner eingabe = new Scanner(System.in);

    public KonsolenView(){
        spiel = new Spiel(this); 
        game();
    }

    public void start(){
        System.out.println("==========================[ U N O ]=====================");
        System.out.println("Wie viele Spieler spielen mit?"); 
        int anzahlSpieler = eingabe.nextInt();
        for(int i = 0; i < anzahlSpieler; i++){
            System.out.print("Wie soll der " + (i+1) + ". Spieler heißen? ");
            String name = eingabe.next();
            spiel.addSpieler(new UnoSpieler(name));
        }
        System.out.println("Das Spiel Uno beginnt!");
        System.out.println("==========================[       ]=====================");
    }

    public void showSpiel(){
        System.out.println("==========================[Spieler]=====================");
        System.out.println("Aktueller Spieler: " + spiel.getAktuellerSpieler().getBenutzername());
        System.out.print("Deine Handkarten:"); 
        Handkarten hK = spiel.getAktuellerSpieler().getHandkarten();
        for(UnoKarte k: hK.getKarten()){
            System.out.print(k.toString()+" ");
        }
        System.out.println("==========================[       ]=====================");
        System.out.println("==========================[ Tisch ]=====================");
        Kartenstapel aStapel = spiel.getAblagestapel();
        Kartenstapel nStapel = spiel.getNachZiehstapel();
        System.out.println("Zu bedienende Karte: " + aStapel.toString());
        System.out.println("Nachziehstapel:" + nStapel.toString());
        System.out.println("==========================[       ]=====================");
    }

    public void spielzug(){
        if(!spiel.moeglicheKarten()){
            System.out.println("Du kannst nichts legen") ;
            spiel.spielerZiehtKarte();
            spiel.naechsteSpieler();
            return;
        }
        System.out.println("Was möchtest du tun? Gib die Nummer der Handkarte (von links)ein");
        int kartenNummer = eingabe.nextInt(); 
        if(!spiel.karteSpielen(kartenNummer-1)){
            System.out.println("Diese Karte kann nicht gelegt werden");
        }
        spiel.naechsteSpieler();
    }

    public void siegerAngeben(){
        System.out.println("Der Spieler " + spiel.gewinnerVorhanden().getBenutzername() + " hat gewonnen."); 
        System.out.println("Die anderen Spieler haben noch Karten:"); 
    }

    public void game(){
        start();
        spiel.start();
        while(spiel.gewinnerVorhanden() == null){
            showSpiel();
            spielzug();    
        }
        siegerAngeben();
        
    }

    

    public static void main(String[] args){
        new KonsolenView();
    }
}