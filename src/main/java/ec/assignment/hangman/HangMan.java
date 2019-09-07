package ec.assignment.hangman;

public class HangMan {

    public static void main( String[] args )
    {
        String[] wordsArray = {"Java","JavaScript","HTML","CSS","SQL"};
        RandomSecretWord secretWords = new RandomSecretWord(wordsArray);
        System.out.println(secretWords.getSecretWord());
    }
}
