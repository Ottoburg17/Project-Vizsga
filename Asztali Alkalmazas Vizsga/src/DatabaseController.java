import java.sql.*;
import java.util.ArrayList;

public class DatabaseController {
    private static final String DB_URL = "jdbc:sqlite:Database/golf.db";

    public DatabaseController() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been connected.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> getPlayers() {
        ArrayList<String> players = new ArrayList<>();
        String sql = "SELECT name FROM Players";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                players.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return players;
    }

    public ArrayList<String> getTournaments() {
        ArrayList<String> tournaments = new ArrayList<>();
        String sql = "SELECT name FROM Tournaments";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                tournaments.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tournaments;
    }

    public void saveData(String player, String tournament, int round1, int round2, int round3, int round4) {
        String sql = "INSERT INTO Results(player, tournament, round1, round2, round3, round4) VALUES(?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, player);
            pstmt.setString(2, tournament);
            pstmt.setInt(3, round1);
            pstmt.setInt(4, round2);
            pstmt.setInt(5, round3);
            pstmt.setInt(6, round4);
            pstmt.executeUpdate();
            
            System.out.println("Data has been saved.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
