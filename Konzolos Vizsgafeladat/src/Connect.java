import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private Connection conn;

    public Connect() {
        conn = null;
    }

    public void connecting() {
        String connectStr = "jdbc:mariadb://localhost:3306/diakdu_golf.db?user=diakdu&password=123";

        try {
            conn = DriverManager.getConnection(connectStr);
        } catch (SQLException e) {
            System.out.println("Hiba a kapcsolódás során: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
