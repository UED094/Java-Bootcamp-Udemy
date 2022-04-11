import javax.sound.midi.Track;

public class Person {
    private String name;
    private String nationality;
    private String dateOfBirth;
    private String[] passport;
    private int seatNumber;

    public Person(String name, String nationality, String dateOfBirth, int seatNumber) {
        this.name = name;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.seatNumber = seatNumber;
    }

    public Person(Person source) {
        this.name = source.name;
        this.nationality = source.nationality;
        this.dateOfBirth = source.dateOfBirth;
        this.seatNumber = source.seatNumber;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getNationality() {
        return this.nationality;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public int getSeatNumber() {
        return this.seatNumber;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
    *  Function name: applyPassport
    *  @return (boolean)
    *
    *  Inside the function:
    *     1. Returns a random boolean of true or false.
    */
    public boolean applyPassport() {
        double randomValue = Math.random();
        if (randomValue < 0.5) {
            return true;
        } else {
            return false;
        }
    }

    /**
    *  Function name: chooseSeat
    *
    *  Inside the function:
    *    1. Sets this.seat to a random number between 1 -- 11.
    */
    public void chooseSeat() {
        int seatNumber = (int)(Math.random() * 11) + 1;
        this.seatNumber = seatNumber;
    }
}
