package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Cart;
import src.main.models.Item;

public class CartTest {

    Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
        cart.add(new Item("Pepsi", 1.99));
        cart.add(new Item("Crush", 1.99));
    }

    @Test
    public void itemAddedTest() {
        assertTrue(cart.contains(new Item("Pepsi", 1.99)));
    }

    @Test
    public void skipsDuplicate() {
        assertFalse(cart.add(new Item("Pepsi", 1.99)));
    }

    @Test
    public void removedItemTest() {
        cart.remove("Pepsi");
        assertFalse(cart.contains(new Item("Pepsi", 1.99)));
    }

    @Test
    public void subtotalIsValid() {
        assertEquals(3.98, cart.getSubtotal());
    }

    @Test
    public void taxIsValid() {
        assertEquals(6.5, cart.getTax(50));
    }

    @Test
    public void totalIsValid() {
        assertEquals(56.5, cart.getTotal(50, 6.5));
    }

}
