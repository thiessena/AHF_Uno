import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
    private JButton drawCardButton;
    JPanel buttonPanel;

    private List kartenStapel = new ArrayList<>();

    public Karte karte = new Karte("g", 1);

    public GUI() {
        setTitle("Uno Kartenspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Erstellen Sie die GUI-Elemente
        drawCardButton = new JButton("Karte ziehen");
        ArrayList<JButton> spielerKartenPanel = new ArrayList<JButton>();

        // Fügen Sie die GUI-Elemente dem Fenster hinzu
        buttonPanel = new JPanel();
        JButton k0 = new JButton("1, rot");
        k0.addActionListener(this);
        k0.setActionCommand("Button " + i);
        spielerKartenPanel.add(k0);
        handkartenAnzeigen(spielerKartenPanel);

        JPanel labelPanel = new JPanel(new GridLayout(2, 1));

        drawCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spielerKartenPanel.add(new JButton("9, grün"));
                buttonPanel.add(spielerKartenPanel.get(spielerKartenPanel.size() - 1));
                buttonPanel.updateUI();
                System.out.println(spielerKartenPanel.size());
            }
        });

        for (int i = 0; i < spielerKartenPanel.size(); i++) {
            spielerKartenPanel.get(i).addActionListener(this);
        }

        add(buttonPanel, BorderLayout.SOUTH);
        add(labelPanel, BorderLayout.CENTER);
    }

    public void addPlayCardListener(ActionListener listener) {
        // die Jeweilige Karte soll ausgespielt werden
    }

    public void handkartenAnzeigen(ArrayList<JButton> karten) {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        buttonPanel.add(drawCardButton);
        for (int i = 0; i <= karten.size() - 1; i++) {
            buttonPanel.add(karten.get(i));
        }

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(spielerKartenPanel.get(0)) or true){
            System.out.println(e.getActionCommand());
        }
        System.out.print("Hallo");
    }

    public static void main(String[] args) {
        // UnoModel model = new UnoModel();
        GUI view = new GUI();
        // Controller controller = new Controller(model, view);
        view.setVisible(true);
    }
}
