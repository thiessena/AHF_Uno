
package archiv;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUISpiel extends JFrame {
    private JButton drawCardButton;
    private JLabel playerHandLabel;
    private JLabel playedCardsLabel;
    JPanel buttonPanel; //Zum Anzeigen, der eigenen Handkarten
    JPanel spielerPanel; //Zum Anzeigen der anderen Spieler

    private UnoSpieler sp;
    private Spiel spiel;

    public GUISpiel(Spiel pSpiel, UnoSpieler pSpieler) {
        setTitle("Uno Kartenspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());
        spiel = pSpiel;

        // Erstellen Sie die GUI-Elemente
        drawCardButton = new JButton("Karte ziehen");
        playerHandLabel = new JLabel("Spielerhand:");
        playedCardsLabel = new JLabel("Gespielte Karten:");
        // Fügen Sie die GUI-Elemente dem Fenster hinzu
        buttonPanel = new JPanel();

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        labelPanel.add(playerHandLabel);
        labelPanel.add(playedCardsLabel);

        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.CENTER);
    }

    public void handkartenAnzeigen(ArrayList<String> karten) {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonPanel.add(drawCardButton);
        for (int y = 0; y < karten.size(); y++) {
            buttonPanel.add(new JButton(karten.get(y).toString()));
        }
    }

    public static void main(String[] args) {
        Spiel spiel = new Spiel(); 
        spiel.addSpieler(new UnoSpieler("Andi"));
        spiel.addSpieler(new UnoSpieler("Basti"));

        GUISpiel sp1 = new GUISpiel(spiel, spiel.getAlleSpieler().get(0));
        sp1.setVisible(true);
        GUISpiel sp2 = new GUISpiel(spiel,spiel.getAlleSpieler().get(1)); 
        sp2.setVisible(true);
    }
}
