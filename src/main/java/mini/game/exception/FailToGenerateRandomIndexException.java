package mini.game.exception;

public class FailToGenerateRandomIndexException extends Throwable {
    private final static String errorMessage = "Cannot generate a random index.";

    public FailToGenerateRandomIndexException() {
        super(errorMessage);
    }
}
