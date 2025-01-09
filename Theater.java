import java.util.List;
import java.util.Map;

public class Theater {
    private String location;
    private int seatingCapacity;

    private DatabaseOperation db = new DatabaseOperation();

    // Constructor with parameters
    public Theater(String location, int seatingCapacity) {
        this.location = location;
        this.seatingCapacity = seatingCapacity;
    }

    public void insertTheater(String location, int seatingCapacity) {
        this.location = location;
        this.seatingCapacity = seatingCapacity;
        String sql = "INSERT INTO theaters (Location, SeatingCapacity) VALUES (?, ?)";
        Object[] values = {location, seatingCapacity};
        int rowsAffected = db.executeUpdate(sql, values);
        if (rowsAffected > 0)
            System.out.println("Theater inserted successfully");
        else
            System.out.println("Something went wrong. Theater not inserted.");
    }

    public void showTheaters() {
        String sql = "SELECT * FROM theaters";
        List<Map<String, Object>> theaters = db.getRecords(sql);
        for (Map<String, Object> theater : theaters) {
            System.out.println("Theater ID: " + theater.get("TheaterID"));
            System.out.println("Location: " + theater.get("Location"));
            System.out.println("Seating Capacity: " + theater.get("SeatingCapacity"));
            System.out.println("-----------------------");
        }
    }

    public String getLocation() {
        return location;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
}
