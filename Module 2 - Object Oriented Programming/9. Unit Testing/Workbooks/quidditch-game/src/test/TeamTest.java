package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import kotlin.jvm.internal.CharSpreadBuilder;
import src.main.models.Game;
import src.main.models.Team;

public class TeamTest {
    static Game game;

    @Before
    public void setup() {
        game = new Game(new Team("GRYFFINDOR", "Oliver", "Harry",
                new String[] { "Angelina", "Ginny", "Katie" }),
                new Team("SLYTHERIN", "Vincent", "Draco",
                        new String[] { "Bridget", "Harper", "Malcolm" }));

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

    @Test
    public void getPlaceholderTest() {
        assertEquals("chaser", game.getPlaceholder("<chaser> gets the next pass"));
    }

    @Test
    public void replacePlaceholderTest() {
        assertEquals("Katie gets the next pass", game.replacePlaceholder("<chaser> gets the next pass", "chaser",
                "Katie"));
    }

    @Test
    public void quaffleScoreTest() {
        Team team = game.getTeam("GRYFFINDOR");
        game.quaffleScore(team);
        game.quaffleScore(team);
        assertEquals(20, game.getScore(team));
    }

    @Test
    public void catchSnitchTest() {
        game.catchSnitch(game.getTeam("SLYTHERIN"));
        assertEquals(150, game.getScore(game.getTeam("SLYTHERIN")));
    }

    

}
