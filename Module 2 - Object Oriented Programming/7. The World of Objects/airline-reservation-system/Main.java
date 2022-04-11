import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        Person person = new Person("Ugur Emre Dogan", "Turkish", "11/05/1994", 5 );

        System.out.println(
            "Name: " + person.getName() + "\n" + 
            "Nationality: " + person.getNationality() + "\n" + 
            "Date of Birth: " + person.getDateOfBirth() + "\n" + 
            "Seat Number: " + person.getSeatNumber() + "\n");
        
        person.chooseSeat();
        
        Person person2 = new Person(person);

        person2.setName("Nilay Kanova Dogan");
        person2.setNationality("Albanian");
        person2.setDateOfBirth("07/12/1994");
        System.out.println(
            "Name: " + person2.getName() + "\n" + 
            "Nationality: " + person2.getNationality() + "\n" + 
            "Date of Birth: " + person2.getDateOfBirth() + "\n" + 
            "Seat Number: " + person2.getSeatNumber() + "\n");

        if (person.applyPassport()) {
            System.out.println("Congratulations " + person.getName() + ". Your passport was approved!");
        } else {
            System.out.println("We're sorry " + person.getName() + ". We cannot process your application.");
        }
        



    }
}
