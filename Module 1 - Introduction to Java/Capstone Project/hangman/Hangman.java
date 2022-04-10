import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

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
        String word = randomWord(words);
        char[] characters = word.toCharArray();
        char[] placeholder = createPlaceHolder(characters) ;
        System.out.println("Welcome to the Hangman Game!");
        System.out.println("You know the rules... Enter one letter a time until you find the right word...");
        
        //System.out.println(word);
        char guessLetter = scan.nextLine().charAt(0);
        System.out.println(checkGuess(guessLetter, characters));
        int misses = 0;
        while (misses <= 6) {

            
        }

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
}



