package ec.assignment.hangman;

import java.util.Random;

public class RandomSecretWord {

    private String[] secretWords;
    private String secretWord;

    public RandomSecretWord (String[] randomSecretWords) {
        this.secretWords = randomSecretWords;
        this.secretWord = selectRandomSecretWord(secretWords);
    }

    public String[] getSecretWords () {
        return secretWords;
    }

    public String getSecretWord () {
        return secretWord;
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
}
