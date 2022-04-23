package src.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Team;

public class TeamTest {

    @Before
    public void setup() {

    }

    @Test
    public void hasNullTest() {
        String[] chasers = new String[] { null, "Ginny", "Katie" };
        assertTrue(Team.hasNull(chasers));
    }

    @Test
    public void hasBlank() {
        String[] chasers = { "    ", "Ginny", "Katie" };
        assertTrue(Team.hasBlank(chasers));
    }

}
