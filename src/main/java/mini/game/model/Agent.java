package mini.game.model;

import org.apache.commons.lang3.math.NumberUtils;

public class Agent {
    private static final String WINNING_OUTPUT = "4A0B";

    private SecretNumberGenerator secretNumberGenerator;

    public Agent() {
        this.secretNumberGenerator = new SecretNumberGenerator();
    }

    public boolean isValidateInput(String input) {
        if (input.length() != 4 || !NumberUtils.isParsable(input)) return false;
        return true;
    }

    public String checkPlayerInput(String input) {
        return getFeedback(input, secretNumberGenerator.getSecretNumbers());
    }

    protected String getFeedback(String input, Integer[] secretNumber) {
        String feedback = "";
        return feedback;
    }

	public boolean isPlayerWin(String feedback) {
        if (WINNING_OUTPUT.equals(feedback)) return true;
		return false;
	}
}