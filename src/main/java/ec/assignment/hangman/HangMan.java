package ec.assignment.hangman;

import java.util.Random;

public class HangMan {

    private String[] secretWords;
    private String secretWord;
    private int numberOfGuesses;
    private StringBuilder allGuesses = new StringBuilder();
    private char[] correctGuesses;

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

    public String matchGuess (String guesses) {
        String result = "";
        String guessedWord = allGuesses.append(guesses).toString();
        if (getSecretWord().equalsIgnoreCase(guessedWord)) {
             result = getSecretWord();
        } else {
            result = matchCaharcterGuess(guesses).toString();
        }
        return result;
    }

    private StringBuilder matchCaharcterGuess (String guesses) {
        StringBuilder charcterGuess = new StringBuilder();
        char[] secretWordArray = secretWord.toCharArray();
        for (int k = 0; k < secretWordArray.length; k++) {
            if (secretWordArray[k] == guesses.charAt(k)) {
                charcterGuess.append(guesses.charAt(k));
                break;
            }
        }
        return  charcterGuess;
    }
}
