public class App {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("GolfEredmenyek.csv");
            return;
        }

        String playersFile = args[0];
        String resultsFile = args[1];

        FileController fileController = new FileController();
        DatabaseController dbController = new DatabaseController(playersFile, resultsFile);

        // Import players
        int importedPlayers = dbController.importPlayers();
        System.out.println(importedPlayers + " players imported successfully.");

        // Import results
        int importedResults = dbController.importResults();
        System.out.println(importedResults + " results imported successfully.");
    }
}
