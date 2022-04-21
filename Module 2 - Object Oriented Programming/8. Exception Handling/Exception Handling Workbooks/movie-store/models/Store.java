package models;

import java.util.ArrayList;
import java.util.jar.Attributes.Name;

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
        if (!action.equals("sell") && !action.equals("rent") && !action.equals("return")) {
            throw new IllegalArgumentException("This action cannot be done choose sell/rent/return.");
        }
        if (movieName == null || movieName.isBlank()) {
            throw new IllegalArgumentException("Movie name cannot be null/blank.");
        }
        if (movies.isEmpty()) {
            throw new IllegalStateException("There is no movie to be action on.");
        }

        for (int i = 0; i < this.movies.size(); i++) {
            if (getMovie(i).getName().equalsIgnoreCase(movieName)) {
                switch (action) {
                    case "sell":
                        if (!getMovie(i).isAvailable()) {
                            throw new IllegalStateException("The movie you are trying to sell is rented.");
                        }
                        this.movies.remove(i);
                        break;
                    case "rent":
                        if (!getMovie(i).isAvailable()) {
                            throw new IllegalStateException("The movie is already rented.");
                        }
                        movies.get(i).setAvailable(false);
                        break;
                    case "return":
                        if (getMovie(i).isAvailable()) {
                            throw new IllegalStateException("You cannot return an item if it is already in-stock.");
                        }
                        movies.get(i).setAvailable(true);
                        break;
                    default:
                        System.out.println("Wrong Action Requested!");
                        break;
                }
            }
        }
    }

    public Movie getMovie(String name) {
        for (int i = 0; i < this.movies.size(); i++) {
            if (getMovie(i).getName().equals(name)) {
                return new Movie(getMovie(i));
            }
        }
        return null;
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
