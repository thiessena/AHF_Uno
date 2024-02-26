import java.util.ArrayList;
import java.util.List;

public class Spieler {
   
    private String name;
   
    private List<Karte> handKarten;
   
    public Spieler(String name) {
       this.name = name;
       this.handKarten = new ArrayList<>();
   }
   
   public String getName() {
       return name;
   }
   
   public List<Karte> getHandKarten() {
       return handKarte;
   }
   
   public void addKarte(Karte karte) {
       handKarten.add(karte);
   }
   
   public void removeKarte(Karte karte) {
       handkarten.remove(karte);
   }

}
