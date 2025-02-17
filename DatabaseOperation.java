import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseOperation {
    static final String DB_URL = "jdbc:mysql://localhost:3306/movieticketbookingsystem";
    static final String USER = "root";
    static final String PASS = "AS4086@4086";

    public Connection connectToDatabase() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
        return conn;
    }

    public int executeUpdate(String sql, Object[] values) {
        int rowsAffected = 0;
        try (Connection conn = connectToDatabase();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                ps.setObject(i + 1, values[i]);
            }
            rowsAffected = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }

    public List<Map<String, Object>> getRecords(String sql) {
        List<Map<String, Object>> records = new ArrayList<>();
        try (Connection conn = connectToDatabase();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(rsmd.getColumnName(i), rs.getObject(i));
                }
                records.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}