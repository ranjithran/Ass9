package Ass9.Logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import Ass9.Model.Movie;

public class MovieManpulator {
    
    public static List<Movie> populateMovies(File file) {
        List<Movie> ml = new ArrayList<Movie>();
        try (BufferedReader bReader = new BufferedReader(new FileReader(file))) {
            String s = "";
            while ((s = bReader.readLine()) != null) {
                String[] l = s.split(",");
                Movie m = new Movie();
                m.setMovieId(Integer.valueOf(l[0]));
                m.setMovieName(l[1]);
                m.setLanguage(l[2]);
                m.setMovieType(l[3]);
                m.setReleaseDate(LocalDate.parse(l[4].trim(), DateTimeFormatter.ofPattern("d MMMM u", Locale.ENGLISH)));
                m.setCasting(new ArrayList<String>(Arrays.asList(l[5].replace("[", "").replace("]", "").split("-"))));
                
            ml.add(m);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return ml;
    }
    public static void serializeMovies(List<Movie> movies, String fileName){
        try
        {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(movies);
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
    }
    public static List<Movie> deserializeMobies(String fileName){
        List<Movie> al=new ArrayList<Movie>();
        try
        {
            FileInputStream fos = new FileInputStream(fileName);
            ObjectInputStream oos = new ObjectInputStream(fos);
            al=(ArrayList) oos.readObject();
            oos.close();
            fos.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return al;
    }
    public static List<Movie> getMoviesRealeasedInYear(int year,File file){
        List<Movie> al=new ArrayList<Movie>();
        try {
            for (Movie movie : populateMovies(file)) {
                
                if(year==movie.getyear())al.add(movie);
            }
        } catch (Exception e) {
            
        }
        return al;
    }
}
