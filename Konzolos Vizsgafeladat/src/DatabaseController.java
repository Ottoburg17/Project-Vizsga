import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DatabaseController {

    private Connection conn;
    private String playersFile;
    private String resultsFile;

    public DatabaseController(String playersFile, String resultsFile) {
        this.playersFile = playersFile;
        this.resultsFile = resultsFile;
        buildConnection();
    }

    private void buildConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:golf.db");
            if (conn != null) {
                createTables();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTables() {
        String createPlayerTable = "CREATE TABLE IF NOT EXISTS Player (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT)";
        String createResultTable = "CREATE TABLE IF NOT EXISTS Result (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "golfTournament TEXT, " +
                "playerId INTEGER, " +
                "round1 INTEGER, " +
                "round2 INTEGER, " +
                "round3 INTEGER, " +
                "round4 INTEGER, " +
                "totalRounds INTEGER, " +
                "FOREIGN KEY (playerId) REFERENCES Player (id))";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createPlayerTable);
            stmt.execute(createResultTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int importPlayers() {
        int counter = 0;
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(playersFile))) {
            String sql = "INSERT INTO Player (name) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

        
            br.readLine();

            while ((line = br.readLine()) != null) {
                pstmt.setString(1, line);
                pstmt.executeUpdate();
                counter++;
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return counter;
    }

    public int importResults() {
        int counter = 0;
        String line;
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(resultsFile))) {
            String sql = "INSERT INTO Result (golfTournament, playerId, round1, round2, round3, round4, totalRounds) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

          
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                pstmt.setString(1, data[0]);
                pstmt.setInt(2, Integer.parseInt(data[1]));
                pstmt.setInt(3, Integer.parseInt(data[2]));
                pstmt.setInt(4, Integer.parseInt(data[3]));
                pstmt.setInt(5, Integer.parseInt(data[4]));
                pstmt.setInt(6, Integer.parseInt(data[5]));
                pstmt.setInt(7, Integer.parseInt(data[2]) + Integer.parseInt(data[3]) + Integer.parseInt(data[4]) + Integer.parseInt(data[5]));
                pstmt.executeUpdate();
                counter++;
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

        return counter;
    }
}
