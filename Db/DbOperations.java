package Ass9.Db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import Ass9.Model.Movie;

public class DbOperations {
    Connection con;

    public Boolean allAllMoviesInDb(List<Movie> movies) {
        boolean b = true;
        try {
            PreparedStatement ps = con.prepareStatement("Insert into Movie values(?,?,?,?,?,?,?,?);");
            for (Movie movie : movies) {
                ps.setString(1, movie.getMovieId() + "");
                ps.setString(2, movie.getMovieName());
                ps.setString(3, movie.getMovieType());
                ps.setString(4, movie.getLanguage());
                ps.setString(5, movie.getReleaseDate().toString());
                ps.setString(6, movie.getCasting());
                ps.setString(7, movie.getRating() + "");
                ps.setString(8, movie.getTotalBusinessDone() + "");
                ps.addBatch();
            }
            int[] rs = ps.executeBatch();
            for (int i : rs) {
                if (i == 0) {
                    b = false;
                }

            }
        } catch (Exception e) {
            System.out.println("Exception found at Operations" + e);
        }
        return b;
    }

    public boolean addNewMovie(Movie movie) {
        boolean b = true;
        try {
            PreparedStatement ps = con.prepareStatement("Insert into Movie values(?,?,?,?,?,?,?,?);");

            ps.setString(1, movie.getMovieId() + "");
            ps.setString(2, movie.getMovieName());
            ps.setString(3, movie.getMovieType());
            ps.setString(4, movie.getLanguage());
            ps.setString(5, movie.getReleaseDate().toString());
            ps.setString(6, movie.getCasting());
            ps.setString(7, movie.getRating() + "");
            ps.setString(8, movie.getTotalBusinessDone() + "");

            int i = ps.executeUpdate();
            if (i == 0) {
                b = false;
            }

        } catch (Exception e) {
            System.out.println("Exception found at Operations" + e);
        }
        return b;

    }

    public void updateRatings(Movie movie, double rating) {

        try {
            PreparedStatement ps = con.prepareStatement("update Movie  set rating=? where id=?;");

            ps.setString(1, rating + "");
            ps.setString(2, movie.getMovieId() + "");

            int i = ps.executeUpdate();
            if (i == 1) {
                System.out.println("updated rating");
            }

        } catch (Exception e) {
            System.out.println("Exception found at Operations" + e);
        }

    }

    public void updateBusiness(Movie movie, double total) {

        try {
            PreparedStatement ps = con.prepareStatement("update Movie  set totaldone=? where id=?;");

            ps.setString(1, total + "");
            ps.setString(2, movie.getMovieId() + "");

            int i = ps.executeUpdate();
            if (i == 1) {
                System.out.println("updated rating");
            }

        } catch (Exception e) {
            System.out.println("Exception found at Operations" + e);
        }

    }

    public DbOperations() {
        try {
            con = Conn.getConn();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
