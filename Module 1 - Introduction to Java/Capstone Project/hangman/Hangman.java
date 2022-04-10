import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.StringBuilder;
import java.net.SocketTimeoutException;

import javax.print.Doc;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder missedGuesses = new StringBuilder();
        String word = randomWord(words);
        char[] characters = word.toCharArray();
        char[] placeholder = createPlaceHolder(characters) ;
        System.out.println("Welcome to the Hangman Game!");
        System.out.println("You know the rules... Enter one letter a time until you find the right word...");
        
        int misses = 0;
        
        while (misses < 6) {
            System.out.print("Your guess: ");
            char guessLetter = scan.nextLine().charAt(0);
            System.out.println();
            
            if (checkGuess(guessLetter, characters)) {
                updatePlaceholders(guessLetter, placeholder, characters);
            } else {
                missedGuesses.append(guessLetter);
                misses++;
            }
            System.out.println(gallows[misses]);
            
            if (Arrays.equals(placeholder, characters)) {
                System.out.println("Win!");
                break;
            } else if ( !Arrays.equals(placeholder, characters) && misses == 6) {
                System.out.println("RIP!");
                System.out.println("Correct word: " + word);
                break;
            }
            printPlaceholders(placeholder);
            printMissedGuesses(missedGuesses);            
        }
        scan.close();

    }

    // FUNCTIONS 
    /**
     * Function Name : randomWord
     * @param words (String[])
     * @return word (String)
     * 
     * Inside the function:
     *  1. Get a random index in the length of words array.
     *  2. Choose a word with that index.
     *  3. Return randomly choosen word.
     */
    public static String randomWord(String[] words) {
        int index = (int)(Math.random()* words.length);
        String word = words[index];
        return word;
    }

    /**
     * Function Name: createPlaceHolder
     * @param characters (char[])
     * @return placeholder (char[])
     * 
     * Inside the function:
     *  1. Create a char array equals the length of characters array.
     *  2. Assign '_' to all the elements.
     *  3. Return placeholder char array.
     */
    public static char[] createPlaceHolder(char[] characters) {
        char[] placeholder = new char[characters.length];
        for (int i = 0; i < placeholder.length; i++) {
            placeholder[i] = '_';
        }
        return placeholder;
    }

    /**
     * Function Name : checkGuess 
     * @param guessLetter (char)
     * @param characters (char[])
     * @return (boolean)
     * 
     * Inside the function: 
     *  1. Get the char guessLetter and characters array of word's characters.
     *  2. Check if that char has a match inside of that characters array.
     *  3. If it match return true and exit the fuction, if not finish the for loop and return false.
     */
    public static boolean checkGuess(char guessLetter, char[] characters) {
        for (char c : characters) {
            if (c == guessLetter) {
                return true;
            }
        }
        return false;
        }
    
    /**
     * Function Name : updatePlaceholders
     * @param guessLetter (char)
     * @param placeholder (char[])
     * @param characters (char[])
     * 
     * Inside the function: 
     *  1. if guess letter is available in characters array updates the placeholder array.
     */
    public static void updatePlaceholders(char guessLetter, char[] placeholder, char[] characters) {
        for (int i = 0; i < characters.length; i++) {
            if (guessLetter == characters[i]) {
                placeholder[i] = guessLetter;
            }
        }
    }

    /**
     * Function Name : printPlaceholders
     * @param placeholder
     * 
     * Inside the function:
     *  1. Print the placeholder array in a good format.
     */
    public static void printPlaceholders(char[] placeholder) {
        System.out.print("Word: ");
        for (int i = 0; i < placeholder.length; i++) {
            System.out.print(placeholder[i]+" ");
        }
        System.out.println("\n");
    }

    /**
     * Function Name : printMissedGuesses
     * @param missedGuesses
     * 
     * Inside the function:
     *  1. Print the missed letters.
     */
    public static void printMissedGuesses(StringBuilder missedGuesses) {
        System.out.println("Misses: " + missedGuesses + "\n\n");
    }

}



