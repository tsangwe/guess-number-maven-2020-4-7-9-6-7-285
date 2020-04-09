package mini.game;

import mini.game.model.Agent;
import mini.game.model.ConsoleInputReader;

public class GameEngineCotroller {
    private static final String LOSE_MESSAGE = "Haha, loser!";
    private static final String WIN_MESSAGE = "Congrat, you win!";
    
    private Agent agent;
    private int gameTurnsAllowence;
    
    public GameEngineCotroller() {
        this.agent = new Agent();
        this.gameTurnsAllowence = 6;
    }

    public void run() {
        System.out.println("The game start!\nPlease guess 4 numbers between 0-9 :)");
        startTurn(this.gameTurnsAllowence);
    }

    public void startTurn(int gameTurn) {
        if (gameTurn == 0) {
            System.out.println(LOSE_MESSAGE);
            System.exit(0);
        }
        System.out.println("You have " + this.gameTurnsAllowence + " left.\nWhat is the number?");

        // User input
        ConsoleInputReader consoleInputReader = new ConsoleInputReader();
        String playerGuess = consoleInputReader.getInput();

        // Input again if not an valid input
        if (!agent.isValidateInput(playerGuess)) {
            System.out.println("Your input: " + playerGuess + ",\tAgent output: Wrong input, input again");
            startTurn(this.gameTurnsAllowence);
        }

        // Get feedback
        String agentFeedback = agent.checkPlayerInput(playerGuess);
        System.out.println("Your input: " + playerGuess + ",\tAgent output:" + agentFeedback);

        if (agent.isPlayerWin(agentFeedback)) {
            System.out.println(WIN_MESSAGE);
            System.exit(0);
        }

        this.gameTurnsAllowence--;
        startTurn(this.gameTurnsAllowence);
    }
}
