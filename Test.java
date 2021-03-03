package Ass9;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Ass9.Db.DbOperations;
import Ass9.Logic.MovieManpulator;
import Ass9.Model.Movie;

public class Test {
    public static void main(String[] args) {
        // GetMovie From list
        // List<Movie> m = MovieManpulator.populateMovies(new File(Test.class.getResource("movie.txt").getFile()));
        // Inserting data to databases
        DbOperations dOperations = new DbOperations();
        // // if (dOperations.allAllMoviesInDb(m))
        // // System.out.println("inserted");
        //Adding new Movie
        
        // Movie movie=new Movie();

        // movie.setMovieId(6);
        // movie.setMovieName("test");
        // movie.setMovieType("test");
        // movie.setCasting(new
        // ArrayList<String>(Arrays.asList("test","test1","test2")));
        // movie.setReleaseDate(LocalDate.now());
        // movie.setRating(0);
        // movie.setTotalBusinessDone(0);
        // movie.setLanguage("test");
        // dOperations.addNewMovie(movie);

        //Seializations
        // MovieManpulator.serializeMovies(m, "fileName.se");
        //DeSeializations
        // for (Movie movie : MovieManpulator.deserializeMobies("fileName.se")) {
        //     System.out.println(movie);
        // }
        //List by year
        // for (Movie string : MovieManpulator.getMoviesRealeasedInYear(2010,new File(Test.class.getResource("movie.txt").getFile()))) {
        //     System.out.println(string);
        // }
        //Update Rating
        Movie m=new Movie();
        m.setMovieId(5);
        dOperations.updateBusiness(m, 890);
    }
}
