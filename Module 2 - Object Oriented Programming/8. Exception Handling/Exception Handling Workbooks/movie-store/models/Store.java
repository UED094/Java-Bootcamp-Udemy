package models;

import java.security.spec.MGF1ParameterSpec;
import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Store(Store source) {
        for (int i = 0; i < source.movies.size(); i++) {
            this.movies.add(new Movie(source.movies.get(i)));
        }
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.add(index, movie);
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public void action(String movieName, String action) {
        for (int i = 0; i < this.movies.size(); i++) {
            if (getMovie(i).getName().equalsIgnoreCase(movieName)) {
                if (action.equalsIgnoreCase("Sell")) {
                    movies.get(i).setAvailable(false);
                    this.movies.remove(i);
                } else if (action.equalsIgnoreCase("Rent")) {
                    movies.get(i).setAvailable(false);
                } else if (action.equalsIgnoreCase("Return")) {
                    movies.get(i).setAvailable(true);
                }
            }
        }
    }

    public String toString() {
        String temp = "";

        for (int i = 0; i < movies.size(); i++) {
            temp += getMovie(i);
            temp += "\n\n";
        }
        return temp;
    }

}
