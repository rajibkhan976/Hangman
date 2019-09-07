package ec.assignment.hangman;

import java.util.Random;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String[] wordsArray = {"Java","JavaScript","HTML","CSS","Oracle","SQL","Android"};
        HangMan secretWordsGame = new HangMan(wordsArray, 8);
        System.out.println(secretWordsGame.getSecretWord());
        System.out.println(secretWordsGame.hideSecretWord());
        Scanner userInput = new Scanner(System.in);
        boolean keepAlive = true;

        while (keepAlive) {
            System.out.println(secretWordsGame.matchGuess(userInput.nextLine()));
            keepAlive = false;
        }
    }
}
