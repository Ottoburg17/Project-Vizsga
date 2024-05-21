import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        DatabaseController dbController = new DatabaseController();
        SwingUtilities.invokeLater(() -> new MainFrame(dbController));
    }
}
