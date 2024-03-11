public class Karte {     
    private String farbe;     
    private int ziffer;     
    
    public Karte(String farbe, int ziffer) {         
        this.farbe = farbe;         
        this.ziffer = ziffer;     
    }     
    
    public String getFarbe() {         
        return farbe;     
    }     
    
    public int getZiffer() {         
        return ziffer;     
    }     
        
    @Override    
        
    public String toString() {         
            return farbe + " " + ziffer;     
        } 
    }
