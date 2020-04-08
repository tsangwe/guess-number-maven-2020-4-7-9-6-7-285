package mini.game.model;

import java.security.GeneralSecurityException;

public class Agent {
    private static final String WINNING_OUTPUT = "4A0B";

    private SecretNumberGenerator secretNumberGenerator;

    public Agent() {
        this.secretNumberGenerator = new SecretNumberGenerator();
    }

    public boolean isValidateInput(String input) {
        if (input.length() != 4) return false;
        return true;
    }

    public String checkPlayerInput(String input) {
        // TODO: implement logic here
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