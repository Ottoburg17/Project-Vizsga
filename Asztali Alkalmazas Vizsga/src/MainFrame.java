import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    private JComboBox<String> playerComboBox;
    private JComboBox<String> tournamentComboBox;
    private JTextField round1Field;
    private JTextField round2Field;
    private JTextField round3Field;
    private JTextField round4Field;
    private JButton saveButton;

    private DatabaseController dbController;

    public MainFrame(DatabaseController dbController) {
        this.dbController = dbController;
        setTitle("Golf Score Recorder");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        addComponentsToPane(getContentPane());
        setVisible(true);
    }

    private void initComponents() {
        playerComboBox = new JComboBox<>();
        ArrayList<String> players = dbController.getPlayers();
        for (String player : players) {
            playerComboBox.addItem(player);
        }

        tournamentComboBox = new JComboBox<>();
        ArrayList<String> tournaments = dbController.getTournaments();
        for (String tournament : tournaments) {
            tournamentComboBox.addItem(tournament);
        }

        round1Field = new JTextField(5);
        round2Field = new JTextField(5);
        round3Field = new JTextField(5);
        round4Field = new JTextField(5);

        saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveData());
    }

    private void addComponentsToPane(Container pane) {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Player:"));
        panel.add(playerComboBox);
        panel.add(new JLabel("Tournament:"));
        panel.add(tournamentComboBox);
        panel.add(new JLabel("Round 1:"));
        panel.add(round1Field);
        panel.add(new JLabel("Round 2:"));
        panel.add(round2Field);
        panel.add(new JLabel("Round 3:"));
        panel.add(round3Field);
        panel.add(new JLabel("Round 4:"));
        panel.add(round4Field);
        panel.add(saveButton);

        pane.add(panel, BorderLayout.CENTER);
    }

    private void saveData() {
        String selectedPlayer = (String) playerComboBox.getSelectedItem();
        String selectedTournament = (String) tournamentComboBox.getSelectedItem();
        int round1 = Integer.parseInt(round1Field.getText());
        int round2 = Integer.parseInt(round2Field.getText());
        int round3 = Integer.parseInt(round3Field.getText());
        int round4 = Integer.parseInt(round4Field.getText());

        dbController.saveData(selectedPlayer, selectedTournament, round1, round2, round3, round4);
    }
}
