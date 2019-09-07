package ec.assignment.hangman;

import java.util.Random;

public class App 
{
    public static void main( String[] args )
    {
        String[] wordsArray = {"Java","JavaScript","HTML","CSS","Oracle","SQL","Android"};
        HangMan secretWords = new HangMan(wordsArray);
        System.out.println(secretWords.returnDashedSecretWord());
    }
}
