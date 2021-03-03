package Ass9.Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Movie implements Serializable,Comparable<Movie>{
    private static final long serialVersionUID = 1L;
    private int movieId;
    private String movieName;
    private String movieType;
    private String language;
    private LocalDate releaseDate;
    private List<String> casting;
    private double rating;
    private double totalBusinessDone;

    public Movie() {
        rating = totalBusinessDone = 0;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCasting() {
        return casting.toString();
    }

    public void setCasting(List<String> casting) {
        this.casting = casting;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getTotalBusinessDone() {
        return totalBusinessDone;
    }

    public void setTotalBusinessDone(double totalBusinessDone) {
        this.totalBusinessDone = totalBusinessDone;
    }
    public int getyear(){
        return releaseDate.getYear();
    }
    @Override
    public String toString() {
        return "Movie [casting=" + casting + ", language=" + language + ", movieId=" + movieId + ", movieName="
                + movieName + ", movieType=" + movieType + ", rating=" + rating + ", releaseDate=" + releaseDate
                + ", totalBusinessDone=" + totalBusinessDone + "]";
    }

    @Override
    public int compareTo(Movie o) {
        
        return Double.compare(this.getTotalBusinessDone(),o.getTotalBusinessDone());
    }

}
