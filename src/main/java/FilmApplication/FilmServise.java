package FilmApplication;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmServise {
    private static Connection conn = null;

    static {
        String url = "jdbc:mysql://localhost:3306/filmproject";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int insertFilm(Film newFilm){
        int n=0;
        String insertQuery = "insert into filmapp values(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        try {
            pstmt =conn.prepareStatement(insertQuery);
           pstmt.setInt(1,newFilm.getFilmID());
           pstmt.setString(2,newFilm.getFilmName());
           pstmt.setInt(3,newFilm.getFilmYear());
           pstmt.setString(4,newFilm.getFilmLang());
           pstmt.setDouble(5,newFilm.getFilmRating());
           int q = pstmt.executeUpdate();
            System.out.println(q+" query executed ");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       return n;
    }

    public int  updateFilm(Film newFilm) {
        int n= 0;
        String updateQuery = "update filmApp set filmYear = " + newFilm.getFilmYear() + " where filmNmae = '" + newFilm.getFilmName() + "'";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            n = stmt.executeUpdate(updateQuery);
            System.out.println(n + " update query executed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  n;
    }

    public List<Film> showRating() {
        String query = "select filmRating from filmapp where filmRating > 5";
        List<Film> filmList = new ArrayList<>();

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int filmRating = rs.getInt(1); // Use index 1 for the column
                Film film = new Film(filmRating);
                filmList.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmList;
    }

    public List<Film> showFiveFilm() {
        String query = "SELECT filmNmae FROM filmapp WHERE filmRating > 8 limit 5";
        List<Film> filmList = new ArrayList<>();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String filmName = rs.getString(1);
                Film film = new Film(filmName);
                filmList.add(film);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmList;
    }

}
