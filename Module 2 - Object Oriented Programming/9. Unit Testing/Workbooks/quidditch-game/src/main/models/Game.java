package src.main.models;

import java.security.Key;
import java.util.HashMap;

public class Game {
    private static int gameCount;
    private HashMap<Team, Integer> scoreboard;

    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<Team, Integer>();

        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);

        gameCount++;
    }

    public Integer getScore(Team team) {
        return this.scoreboard.get(team);
    }

    public void setScore(Team team, Integer score) {
        this.scoreboard.put(team, score);
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream().filter((key) -> key.getHouse().equals(name)).findFirst().orElse(null);
    }

    public static int getGameCount() {
        return gameCount;
    }

}
