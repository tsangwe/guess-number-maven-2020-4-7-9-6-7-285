package mini.game.model;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.math.NumberUtils;

public class Agent {
    private static final String WINNING_OUTPUT = "4A0B";

    private SecretNumberGenerator secretNumberGenerator;

    public Agent() {
        this.secretNumberGenerator = new SecretNumberGenerator();
    }

    public boolean isValidateInput(String input) {
        if (input.length() != 4 || !NumberUtils.isParsable(input)) return false;

        // Check for duplicates
        Set<String> map = new HashSet<String>();
        for (char numInChar: input.toCharArray()) {
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
        Integer[] inputIntegerArray = new Integer[4];
        for(int i: secretNumber) {System.out.println(i);}
        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            inputIntegerArray[charIndex] = Integer.parseInt(String.valueOf(input.charAt(charIndex)));
        }

        for (int currIndex = 0; currIndex < secretNumber.length; currIndex++) {
            if (secretNumber[currIndex].equals(inputIntegerArray[currIndex])) {
                countMatchCharAndPosition++;
                countMatchOnlyChar++;
                continue;
            } else {
                for (int innerIdex = currIndex + 1; innerIdex < secretNumber.length; innerIdex++) {
                    if (inputIntegerArray[currIndex] == secretNumber[innerIdex]) {
                        countMatchOnlyChar++;
                        break;
                    }
                }
            }
        }

        countMatchOnlyChar -= countMatchCharAndPosition;

        return String.format("%dA%dB", countMatchCharAndPosition, countMatchOnlyChar);
    }

	public boolean isPlayerWin(String feedback) {
        if (WINNING_OUTPUT.equals(feedback)) return true;
		return false;
	}
}
