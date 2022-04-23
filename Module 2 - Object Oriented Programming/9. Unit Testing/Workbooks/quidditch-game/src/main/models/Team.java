package src.main.models;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

import javax.lang.model.element.Element;

public class Team {

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    public Team(String house, String keeper, String seeker, String[] chasers) {
        checkParam(house);
        checkParam(keeper);
        checkParam(seeker);
        if (chasers.length != 3) {
            throw new IllegalArgumentException("Chasers should be 3 players.");
        }
        if (hasNull(chasers) || hasNull(chasers)) {
            throw new IllegalArgumentException("Chasers cannot be null/blank.");
        }
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = chasers.clone();
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = source.chasers.clone();
    }

    public String getHouse() {
        return this.house;
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public String getKeeper() {
        return this.keeper;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public String getSeeker() {
        return this.seeker;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public String[] getChasers() {
        return this.chasers.clone();
    }

    public void setChasers(String[] chasers) {
        if (chasers.length != 3) {
            throw new IllegalArgumentException("Chasers should be 3 players.");
        }
        if (hasNull(chasers) || hasNull(chasers)) {
            throw new IllegalArgumentException("Chasers cannot be null/blank.");
        }
        this.chasers = chasers.clone();
    }

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }

    @Override
    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: " + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public static boolean hasNull(String[] array) {
        return Arrays.stream(array)
                .anyMatch(element -> element == null);
    }

    public static boolean hasBlank(String[] array) {
        return Arrays.stream(array)
                .anyMatch(element -> element.isBlank());
    }

    private void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null/blank.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Team)) {
            return false;
        }
        Team team = (Team) o;
        return Objects.equals(house, team.house) && Objects.equals(keeper, team.keeper)
                && Objects.equals(seeker, team.seeker)
                && Objects.equals(Arrays.toString(chasers), Arrays.toString(team.chasers));
    }

    @Override
    public int hashCode() {
        return Objects.hash(house, keeper, seeker, Arrays.toString(chasers));
    }

}
