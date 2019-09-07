package ec.assignment.hangman;

import java.util.Random;

public class HangMan {

    private String[] secretWords;
    private String secretWord;

    public HangMan (String[] randomSecretWords) {
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

    public StringBuilder returnDashedSecretWord () {
        char[] selectedSecretWordArray = getSecretWord().toCharArray();
        StringBuilder replaceSecretWord = new StringBuilder();
        for (int j = 0; j < selectedSecretWordArray.length; j++) {
            replaceSecretWord.append("_" + " ");
        }
        return replaceSecretWord;
    }
}
