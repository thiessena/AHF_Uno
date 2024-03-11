import java.util.ArrayList;
import java.util.List;

public class Spieler {
   
    private String name;
    public Karte abgelegteKarte;
    private List<Karte> handKarten;
    private List<Karte> handKartenS2;
   
    public Spieler(String name) {
       this.name = name;
       this.handKarten = new ArrayList<>();
       this.handKartenS2 = new ArrayList<>();
   }
   
   public String getName() {
       return name;
   }
   
   public List<Karte> getHandKarten() {
       return handKarten;
   }

    public List<Karte> getHandKartenS2() {
        return handKartenS2;
    }
   
   public void addKarte(Karte karte) {
       handKarten.add(karte);
   }
   
    public void addKarteS2(Karte karte) {
        handKartenS2.add(karte);
    }
   
   public void removeKarte(Karte karte) {
       handKarten.remove(karte);
   }

    public void removeKarteS2(Karte karte) {
        handKartenS2.remove(karte);
    }

    public boolean darfLegen(Karte k){
        boolean b = false;
        if(k.getFarbe() == abgelegteKarte.getFarbe() || k.getZiffer() == abgelegteKarte.getZiffer()){
            b = true;
        }
        return b;
    }

}
