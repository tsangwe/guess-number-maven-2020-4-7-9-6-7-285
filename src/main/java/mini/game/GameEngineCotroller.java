package mini.game;

import java.util.Scanner;

import mini.game.model.Agent;

public class GameEngineCotroller {
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
            System.exit(0);
        }
        System.out.println("You have " + this.gameTurnsAllowence + " left.\nWhat is the number?");

        Scanner scanner = new Scanner(System.in);
        String playerGuess = scanner.nextLine();
        scanner.close();
        
        String agentFeedback = agent.checkPlayerInput(playerGuess);

        System.out.println("Your input: " + playerGuess + ",\tAgent output:" + agentFeedback);

        if (agent.isPlayerWin(agentFeedback)) {
            System.out.println("Congrat, you win!");
            System.exit(0);
        }

        this.gameTurnsAllowence--;
        startTurn(this.gameTurnsAllowence);
    }
}
