package ec.assignment.hangman;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String[] wordsArray = {"Java","JavaScript","HTML","CSS","SQL"};
        HangMan secretWords = new HangMan(wordsArray);
        System.out.println(secretWords.getSecretWord());
    }
}
