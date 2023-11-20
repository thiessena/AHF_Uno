import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class GUI extends JFrame {
    private JButton drawCardButton;
    private JButton playCardButton;
    private JLabel playerHandLabel;
    private JLabel playedCardsLabel;

    public GUI() {
        setTitle("Uno Kartenspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Erstellen Sie die GUI-Elemente
        drawCardButton = new JButton("Karte ziehen");
        playCardButton = new JButton("Karte spielen");
        playerHandLabel = new JLabel("Spielerhand:");
        playedCardsLabel = new JLabel("Gespielte Karten:");

        // Fügen Sie die GUI-Elemente dem Fenster hinzu
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(drawCardButton);
        buttonPanel.add(playCardButton);

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        labelPanel.add(playerHandLabel);
        labelPanel.add(playedCardsLabel);

        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.CENTER);
    }

    public void addDrawCardListener(ActionListener listener) {
        drawCardButton.addActionListener(listener);
    }

    public void addPlayCardListener(ActionListener listener) {
        playCardButton.addActionListener(listener);
    }

    /**
     * public void updatePlayerHand(List<Card> playerHand) {
            // Aktualisieren Sie die Spielerhand-Anzeige entsprechend
            // Hier können Sie die Spielerhand in einem JList oder einem anderen GUI-Element anzeigen
        }

        public void updatePlayedCards(List<Card> playedCards) {
            // Aktualisieren Sie die gespielten Karten-Anzeige entsprechend
            // Hier können Sie die gespielten Karten in einem JLabel oder einem anderen GUI-Element anzeigen
        }
     */
    

    public static void main(String[] args) {
        // UnoModel model = new UnoModel();/
        GUI view = new GUI();
        //Controller controller = new Controller(model, view);
        view.setVisible(true);
    }
}