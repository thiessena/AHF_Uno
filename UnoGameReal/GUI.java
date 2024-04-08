import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GUI extends JFrame implements ActionListener {

    private JPanel buttonPanel;
    private JPanel spielerKartenPanel;
    private JButton drawCardButton;

    private Karte newKarte;
    private Karte abKarte;

    private MainGame mGame;
    private JPanel labelPanel;
    private JLabel strKarte;
    private String stringKarte;

    public GUI(MainGame mg) {
        setTitle("Uno Kartenspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        mGame = mg;

        // Erstellen Sie die GUI-Elemente
        drawCardButton = new JButton("Karte ziehen");
        drawCardButton.addActionListener(this);
        spielerKartenPanel = new JPanel();
        spielerKartenPanel.setLayout(new FlowLayout());

        // Fügen Sie die GUI-Elemente dem Fenster hinzu
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(drawCardButton);
        buttonPanel.add(spielerKartenPanel);

        labelPanel = new JPanel(new GridLayout(2, 1));
        strKarte = new JLabel(stringKarte, SwingConstants.CENTER);
        labelPanel.add(strKarte);

        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.CENTER);

    }

    public void createHandkartenButtons(ArrayList<Karte> karten) {
        for (Karte k : karten) {
            spielerKartenPanel.add(new KButton(k, this));
        }
    }

    public void setNewHandkarte(Karte k) {
        newKarte = k;
    }

    public void setAbgelegteKarte(Karte c) {
        abKarte = c;
        stringKarte = abKarte.getFarbe() + "/" + abKarte.getFarbe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * Hier werden die Handkarten verarbeitet. Jeder KButton hat als
         * ActionCommand "Handkarte ...".
         */
        if (e.getActionCommand().startsWith("Handkarte")) {
            // setAbgelegteKarte();

            // Die Klasse Spieler soll hier aufgerufen werden,
            // Es soll angefragt werden ob die Karte zum Stapel passt
            // Alle Karten sollen in einer Liste gespeichert werden!
            labelPanel.updateUI();
            spielerKartenPanel.remove((Component) e.getSource());
            spielerKartenPanel.updateUI();
            return;
        }

        if (e.getSource().equals(drawCardButton)) {
            spielerKartenPanel.add(new KButton(newKarte, this));
            mGame.initNewKarte();
            buttonPanel.updateUI();
            return;
        }

    }
}
