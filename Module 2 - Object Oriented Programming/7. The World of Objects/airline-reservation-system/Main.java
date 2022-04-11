import java.util.Arrays;
public class Main {

    public static void main(String[] args) {

        Person person = new Person("Ugur Emre Dogan", "Turkish", "05/11/1994", 6); 
        if (person.applyPassport() == true) {
            person.setPassport();
        }

        System.out.println(
            "Name: " + person.getName() + "\n" + 
            "Nationality: " + person.getNationality() + "\n" + 
            "Date of Birth: " + person.getDateOfBirth() + "\n" +
            "Seat Number: " + person.getSeatNumber() + "\n" + 
            "Passport: " + Arrays.toString(person.getPassport()) + "\n");
    }
}
