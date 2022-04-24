package src.main.models;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private static int gameCount;
    private HashMap<Team, Integer> scoreboard;

    private static final Integer QUAFFLE_POINTS = 10;
    private static final Integer SNITCH_POINTS = 150;

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
        if (team == null || score == null) {
            throw new IllegalStateException("Team/score cannot be null.");
        }
        this.scoreboard.put(team, score);
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream().filter((key) -> key.getHouse().equals(name)).findFirst().orElse(null);
    }

    public static int getGameCount() {
        return gameCount;
    }

    public String getPlaceholder(String play) {
        return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String value) {
        return play.replaceAll("<" + placeholder + ">", value);
    }

    public void quaffleScore(Team team) {
        this.setScore(team, this.getScore(team) + QUAFFLE_POINTS);
    }

    public void catchSnitch(Team team) {
        this.setScore(team, this.getScore(team) + SNITCH_POINTS);
    }

    public String simulate(String play) {
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();
        String value;
        if (placeholder.equals(Team.getPositionChaser())) {
            quaffleScore(team);
            value = team.getChasers()[random(3)];
        } else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnitch(team);
            value = team.getSeeker();
        } else if (placeholder.equals(Team.getPositionKeeper())) {
            value = team.getKeeper();
        } else {
            return "";
        }
        return replacePlaceholder(play, placeholder, value);
    }

    public Team getRandomTeam() {
        Object[] teams = this.scoreboard.keySet().toArray();
        return (Team) teams[random(teams.length)];

    }

    public int random(int range) {
        return (int) (Math.random() * range);
    }

}
