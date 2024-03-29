import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
    
    private JPanel buttonPanel;
    private JPanel spielerKartenPanel;
    private JButton drawCardButton;

    private Karte newKarte;

    public boolean newKInit;

    public GUI() {
        setTitle("Uno Kartenspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Erstellen Sie die GUI-Elemente
        drawCardButton = new JButton("Karte ziehen");
        drawCardButton.addActionListener(this);
        spielerKartenPanel = new JPanel(); 
        spielerKartenPanel.setLayout(new FlowLayout());
        spielerKartenPanel.add(new KButton(new Karte("rot", 1), this));
        

        // Fügen Sie die GUI-Elemente dem Fenster hinzu
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(drawCardButton);
        buttonPanel.add(spielerKartenPanel);
        
        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        
        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.CENTER);
    }

    public void createHandkartenButtons(ArrayList<Karte> karten) {
        for (Karte k : karten){
            spielerKartenPanel.add(new KButton(k, this));
        }
    }

    public void setNewHandkarte(Karte k){
        newKarte = k;
    }

    public boolean newKarteInit(){
        return newKInit;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        /**
         * Hier werden die Handkarten verarbeitet. Jeder KButton hat als 
         * ActionCommand "Handkarte ...". 
         */
        if(e.getActionCommand().startsWith("Handkarte")){
            System.out.println(e.getActionCommand());
            spielerKartenPanel.remove((Component)e.getSource());
            spielerKartenPanel.updateUI();
            return; 
        }
        
        if(e.getSource().equals(drawCardButton)){
            spielerKartenPanel.add(new KButton(newKarte,this));
            buttonPanel.updateUI();
            System.out.println("Anzahl der Handkarten:" + spielerKartenPanel.getComponentCount());
            return;
        }

    }
}
