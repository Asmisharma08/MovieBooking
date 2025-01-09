public class MovieTicketDriver {
    public static void main(String[] args) {
        Movie m = new Movie("Race 3", "Action", 4.9, 120, "Good movie about racing");
        m.insertMovie();
        m.showMovies();

        Theater t = new Theater("IMAX", 40);
        t.insertTheater("IMAX", 40);
        t.showTheaters();
    }
}
