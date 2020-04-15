package mini.game.model;

import mini.game.generator.SecretNumberGenerator;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.HashSet;
import java.util.Set;

public class Agent {
    private static final int NUMBER_LENGTH = 4;
    private static final String FEEDBACK_PATTERN = "%dA%dB";
    private static final String WINNING_OUTPUT = NUMBER_LENGTH + "A0B";
    private SecretNumberGenerator secretNumberGenerator;


    public Agent() {
        this.secretNumberGenerator = new SecretNumberGenerator();
    }

    public boolean isValidateInput(String input) {
        if (input.length() != NUMBER_LENGTH || !NumberUtils.isParsable(input)) return false;

        // Check for duplicates
        Set<String> map = new HashSet<>();
        for (char numInChar : input.toCharArray()) {
            String numCharInString = String.valueOf(numInChar);
            if (map.contains(numCharInString)) return false;
            map.add(numCharInString);
        }

        return true;
    }

    public String checkPlayerInput(String input) {
        return getFeedback(input, secretNumberGenerator.getSecretNumbers());
    }

    protected String getFeedback(String input, Integer[] secretNumber) {
        int countMatchCharAndPosition = 0;
        int countMatchOnlyChar = 0;
        Integer[] inputIntegerArray = new Integer[secretNumber.length];

        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            inputIntegerArray[charIndex] = Integer.parseInt(String.valueOf(input.charAt(charIndex)));
        }

        for (int currIndex = 0; currIndex < secretNumber.length; currIndex++) {
            if (secretNumber[currIndex].equals(inputIntegerArray[currIndex])) {
                countMatchCharAndPosition++;
                countMatchOnlyChar++;
            } else {
                for (int innerIdex = 0; innerIdex < secretNumber.length; innerIdex++) {
                    if (innerIdex == currIndex) continue;
                    if (inputIntegerArray[currIndex].equals(secretNumber[innerIdex])) {
                        countMatchOnlyChar++;
                        break;
                    }
                }
            }
        }

        countMatchOnlyChar -= countMatchCharAndPosition;

        return String.format(FEEDBACK_PATTERN, countMatchCharAndPosition, countMatchOnlyChar);
    }

    public boolean isPlayerWin(String feedback) {
        return WINNING_OUTPUT.equals(feedback);
    }
}
