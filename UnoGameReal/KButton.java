import java.awt.event.ActionListener;

import javax.swing.JButton;

public class KButton extends JButton{
    private Karte k; 
    
    public KButton(Karte k, ActionListener actionListener){
        super(k.toString());
        this.k = k; 
        this.addActionListener(actionListener); 
        this.setActionCommand("Handkarte " + k.toString());
    }

    public Karte getKarte(){
        return k;
    }

    
}