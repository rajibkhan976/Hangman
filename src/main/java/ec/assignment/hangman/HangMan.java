package ec.assignment.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HangMan {

    private String[] secretWords;
    private String secretWord;
    private int numberOfGuesses;
    private StringBuilder allGuesses = new StringBuilder();
    private char[] correctGuesses = new char[0];

    public HangMan (String[] randomSecretWords, int numberOfGuesses) {
        this.secretWords = randomSecretWords;
        this.numberOfGuesses = numberOfGuesses;
        this.secretWord = selectRandomSecretWord(secretWords);
    }

    public String[] getSecretWords () {
        return secretWords;
    }

    public String getSecretWord () {
        return secretWord;
    }

    public int getNumberOfGuesses () {
        return numberOfGuesses;
    }

    public StringBuilder getAllGuesses () {
        return allGuesses;
    }

    public char[] getCorrectGuesses () {
        return correctGuesses;
    }

    public void setCorrectGuesses (char[] matchedGuesses) {
        int offset = this.correctGuesses.length;
        this.correctGuesses = Arrays.copyOf(this.correctGuesses, offset + matchedGuesses.length);
        for (int m = offset, n = 0; n < matchedGuesses.length; m++, n++) {
            this.correctGuesses[m] = matchedGuesses[n];
        }
    }

    private String selectRandomSecretWord (String[] secretWordsArray) {
        for (int i = 0; i < secretWordsArray.length; i++) {
            Random randomNumber = new Random();
            int randomIndex = randomNumber.nextInt(secretWordsArray.length - i) + i;
            if (randomIndex == secretWordsArray.length) {
                continue;
            } else {
                secretWord = secretWordsArray[randomIndex];
                break;
            }
        }
        return secretWord;
    }

    public StringBuilder hideSecretWord () {
        char[] selectedSecretWordArray = getSecretWord().toCharArray();
        StringBuilder replaceSecretWord = new StringBuilder();
        for (int j = 0; j < selectedSecretWordArray.length; j++) {
            replaceSecretWord.append("_" + " ");
        }
        return replaceSecretWord;
    }

    public boolean matchWordGuess (String guesses) {
        boolean wordGuess = false;
        allGuesses.append(guesses);
        if (getSecretWord().equalsIgnoreCase(guesses)) {
            wordGuess = true;
        }
        return wordGuess;
    }

    public boolean matchCaharcterGuess (String guesses) {
        allGuesses.append(guesses);
        boolean charcterGuess = false;
        for (int k = 0, l = 1; k < getSecretWord().length() && l  <= getSecretWord().length(); k++, l++)
            if (getSecretWord().substring(k, l).equalsIgnoreCase(guesses)) {
                charcterGuess = true;
                break;
            }
        return  charcterGuess;
    }

}
