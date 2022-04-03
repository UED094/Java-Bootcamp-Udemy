import java.util.Scanner;

public class SignUp {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to JavaGram! Let's sign you up.");
        

        //Task 1 - Using Scanner, ask the user questions
        //Ask for their first name.
        System.out.println("What is your name?");
        String name =  scan.nextLine();
        
        //Ask for their last name.
        System.out.println("What is your last name?");
        String lastName = scan.nextLine();
        
        //Ask: how old are you?
        System.out.println("How old are you?");
        String age = scan.nextLine();
        
        //Ask them to make a username.
        System.out.println("What should be your username?");
        String username = scan.nextLine();
        
        //Ask what city they live in.
        System.out.println("What city are you live in?");
        String city = scan.nextLine();
        
        //Ask what country that's from.
        System.out.println("Which country is your city from?");
        String country = scan.nextLine();
        
        //Task 2 - Print their information. 

        System.out.println("Thank you for joining JavaGram!");

        //Print their information like so:
        System.out.println("Your information: ");
        System.out.println("\t First Name: " + name);
        System.out.println("\t Last Name: " + lastName);
        System.out.println("\t Age: " + age);
        System.out.println("\t Username: " + username);
        System.out.println("\t City: " + city);
        System.out.println("\t Country: " + country);

        // Your information:
        //        First Name: Rayan
        //        Last Name: Slim
        //        Age: 27
        //        Username: monotonic_relu
        //        City: Ottawa
        //        Country: Canada
        //


        //close scanner. It's good practice :D !
        scan.close(); 
    }
}