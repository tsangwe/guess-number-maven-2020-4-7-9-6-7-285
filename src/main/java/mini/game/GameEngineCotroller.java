package mini.game;

import mini.game.model.Agent;
import mini.game.model.ConsoleInputReader;

public class GameEngineCotroller {
    private static final String LOSE_MESSAGE = "Haha, loser!";
    private static final String WIN_MESSAGE = "Congrat, you win!";
    private static final String GAME_START_MESSAGE = "The game start!\nPlease guess 4 numbers between 0-9 :)";
    private static final String TURN_ROUND_MESSAGE = "You have %s left.\nWhat is the number?";
    private static final String INVAILD_INPUT_MESSAGE = "Your input: %s,\tAgent output: Wrong input, input again";
    private static final String AGENT_FEEDBACK_MESSAGE = "Your input: %s,\tAgent output: %s";

    private Agent agent;
    private int gameTurnsAllowence;
    
    public GameEngineCotroller() {
        this.agent = new Agent();
        this.gameTurnsAllowence = 6;
    }

    public void run() {
        System.out.println(GAME_START_MESSAGE);
        startTurn(this.gameTurnsAllowence);
    }

    public void startTurn(int gameTurn) {
        if (gameTurn == 0) {
            System.out.println(LOSE_MESSAGE);
            System.exit(0);
        }
        System.out.println(String.format(TURN_ROUND_MESSAGE, this.gameTurnsAllowence));

        // User input
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        String playerGuess = consoleInputReader.getInput();

        // Input again if not an valid input
        if (!agent.isValidateInput(playerGuess)) {
            System.out.println(String.format(INVAILD_INPUT_MESSAGE, playerGuess));
            startTurn(this.gameTurnsAllowence);
        }

        // Get feedback
        String agentFeedback = agent.checkPlayerInput(playerGuess);
        System.out.println(String.format(AGENT_FEEDBACK_MESSAGE, playerGuess, agentFeedback));

        if (agent.isPlayerWin(agentFeedback)) {
            System.out.println(WIN_MESSAGE);
            System.exit(0);
        }

        this.gameTurnsAllowence--;
        startTurn(this.gameTurnsAllowence);
    }
}
