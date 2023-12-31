import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.text.Text;

public class GUI extends JFrame {
    private JButton drawCardButton;
    private JLabel playerHandLabel;
    private JLabel playedCardsLabel;
    JPanel buttonPanel;

    private List kartenStapel = new ArrayList<>();

    public GUI() {
        setTitle("Uno Kartenspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Erstellen Sie die GUI-Elemente
        drawCardButton = new JButton("Karte ziehen");
        ArrayList<String> spielerKarten = new ArrayList<String>();
        spielerKarten.add("1, grün");
        spielerKarten.add("3, grün");
        spielerKarten.add("1, gelb");


        playerHandLabel = new JLabel("Spielerhand:");
        playedCardsLabel = new JLabel("Gespielte Karten:");

        // Fügen Sie die GUI-Elemente dem Fenster hinzu
        buttonPanel = new JPanel();
        spielerKarten.add("1, grün");
        spielerKarten.add("3, grün");
        spielerKarten.add("1, gelb");
        spielerKarten.add("1, rot");
        handkartenAnzeigen(spielerKarten);

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));
        labelPanel.add(playerHandLabel);
        labelPanel.add(playedCardsLabel);

        /**
         * drawCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("Lol");
            }
        });
         */
        

        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.CENTER);
    }

    public void addPlayCardListener(ActionListener listener) {
        //die Jeweilige Karte soll ausgespielt werden
    }

    public void handkartenAnzeigen(ArrayList<String> karten){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        buttonPanel.add(drawCardButton);
        for(int y = 0; y < karten.size(); y++){
            buttonPanel.add(new JButton(karten.get(y).toString()));
        }        
    }
    

    public static void main(String[] args) {
        // UnoModel model = new UnoModel();/
        GUI view = new GUI();
        //Controller controller = new Controller(model, view);
        view.setVisible(true);
    }
}
