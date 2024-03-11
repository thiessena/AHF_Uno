import java.util.ArrayList;
import java.util.List;

public class Spieler {
   
    private String name;
    public Karte abgelegteKarte;
    private List<Karte> handKarten;
   
    public Spieler(String name) {
       this.name = name;
       this.handKarten = new ArrayList<>();
   }
   
   public String getName() {
       return name;
   }
   
   public List<Karte> getHandKarten() {
       return handKarten;
   }
   
   public void addKarte(Karte karte) {
       handKarten.add(karte);
   }
   
   public void removeKarte(Karte karte) {
       handKarten.remove(karte);
   }

   public void handkarteHinzufügen(Karte getKarte){
        handKarten.add(getKarte);
   }

   public void karteAblegen(Karte setKarte){
        abgelegteKarte = setKarte;
   }

}
