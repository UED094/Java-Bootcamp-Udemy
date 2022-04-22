package src.test;

import src.main.models.Store;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Movie;

public class StoreTest {

    Store store;

    @Before
    public void setup() {
        store = new Store();
        store.addMovie(new Movie("The Shawshank Redemption", "Blue-Ray", 9.2));
        store.addMovie(new Movie("The Godfather", "Blue-Ray", 9.1));
    }

    @Test
    public void movieAdded() {
        assertTrue(store.contains(new Movie("The Shawshank Redemption", "Blue-Ray",
                9.2)));
    }

    @Test
    public void sellMovieTest() {
        store.sellMovie("The Godfather");
        assertFalse(store.contains(new Movie("The Godfather", "Blue-Ray", 9.1)));
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("The Godfather");
        assertFalse(store.getMovie(1).isAvailable());
    }

    @Test(expected = IllegalStateException.class)
    public void movieNotInStock() {
        store.rentMovie("The Godfather");
        store.rentMovie("The Godfather");

    }

}
