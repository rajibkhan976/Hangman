package ec.assignment.hangman;

import java.util.Random;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String[] wordsArray = {"Java","JavaScript","HTML","CSS","Oracle","SQL","Android"};
        HangMan secretWordsGame = new HangMan(wordsArray, 8);
        System.out.println("Guess the following word to win the game.");
        System.out.println(secretWordsGame.hideSecretWord());
        System.out.println("You can guess 8 times.");
        System.out.println("You can guess either the complete word or a single letter.");
        System.out.println("Your number of chances will reduce if you make a wrong guess");
        System.out.println(secretWordsGame.getSecretWord());

        Scanner userInput = new Scanner(System.in);
        int numGuess = secretWordsGame.getNumberOfGuesses();
        boolean keepAlive = true;

        while (keepAlive) {
            if (numGuess < 1) {
                keepAlive = false;
            }
            String userGuess = userInput.nextLine();
            if(secretWordsGame.matchWordGuess(userGuess)) {
                System.out.println(secretWordsGame.getSecretWord());
                System.out.println("You won.");
                keepAlive = false;
            } else if (secretWordsGame.matchCaharcterGuess(userGuess)) {
                System.out.println("Your guess matched with a letter");
            } else {
                numGuess = numGuess - 1;
                System.out.println("Your guess is wrong");
            }

        }
    }
}
