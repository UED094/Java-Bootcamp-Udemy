import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import models.Movie;
import models.Store;

public class Main {
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n********************JAVA VIDEO STORE********************\n");
        try {
            loadMovies("movies.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("MOVIES LOADED \n\n");
            System.out.println(store);
        }
        manageMovies();

    }

    /**
     * Name: manageMovies
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. In an infinite loop, the user can choose to a) purchase b) rent c)
     * return d) exit.
     * • case a: ask for the name and sell.
     * • case b: ask for the name and rent.
     * • case c: ask for the name and return.
     * • 3. call close() from the Scanner object.
     */
    public static void manageMovies() {
        Scanner scan = new Scanner(System.in);
        menuLoop: while (true) {
            System.out.println("\nWould you like to \n\ta) purchase\n\tb) rent \n\tc) return.");
            String response = scan.nextLine();

            if (!(response.equals("a") || response.equals("b") || response.equals("c"))) {
                scan.close();
                break;
            }

            System.out.println("Enter the name of the movie:");
            String movieName = scan.nextLine();
            if (movieName == null || movieName.isEmpty()) {
                System.out.println("\n\nThe input you provided is not valid. Please try again\n");
                continue;
            }

            if ((store.getMovie(movieName) == null)) {
                System.out.println("The movie you choose is not in the library.");
                continue;
            }

            switch (response) {
                case "a":
                    if (store.getMovie(movieName).isAvailable()) {
                        store.action(movieName, "sell");
                    } else {
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                    }
                    break;
                case "b":
                    if (store.getMovie(movieName).isAvailable()) {
                        store.action(movieName, "rent");
                    } else {
                        System.out.println("\n\n\n\nThe movie is not available for purchase. Please try again\n");
                    }
                    break;
                case "c":
                    if (!(store.getMovie(movieName).isAvailable())) {
                        store.action(movieName, "return");
                    } else {
                        System.out.println("\n\n\n\nThe movie is already returned. Please try again\n");
                    }
                    break;
                default:
                    break;
            }

            System.out.println("\n\nUPDATED MOVIES\n\n");
            System.out.println(store);
        }
    }

    /**
     * Name: loadMovies
     * 
     * @param fileName (String)
     * @throws FileNotFoundException
     *
     *                               Inside the function:
     *                               • 1. loads movies from <fileName>.txt.
     *                               • 2. adds all movies to the store object's
     *                               movie field.
     *                               Hint: You will need to 'split' a String into
     *                               three Strings.
     */
    public static void loadMovies(String fileName) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(fis);
        while (scanFile.hasNextLine()) {
            String data = scanFile.nextLine();
            String[] splittedData = data.split("--");
            store.addMovie(new Movie(splittedData[0], splittedData[1], Double.parseDouble(splittedData[2])));
        }
        scanFile.close();
    }

}
