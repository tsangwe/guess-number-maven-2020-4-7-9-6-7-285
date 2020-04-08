package mini.game.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecretNumberGenerator {
    private Integer[] secretNumbers;

    public SecretNumberGenerator() {
        genNewSecretNumber();
    }

    public Integer[] getSecretNumbers() {
        return this.secretNumbers;
    }

    public void genNewSecretNumber() {
        Integer[] newSecretNumberArray = new Integer[4];
        ArrayList<Integer> numberPool = new ArrayList<>();
        int range = 9;
        
        for (int count = 0; count <= range; count++) {
            numberPool.add(count);
        }

        for (int currIndex = 0; currIndex < newSecretNumberArray.length; currIndex++) {
            newSecretNumberArray[currIndex] = numberPool.remove(getRandomIndexFromNumberPool(numberPool.size()));
        }

        this.secretNumbers = newSecretNumberArray;
    }

    private int getRandomIndexFromNumberPool(int poolSize) {
        Random random = new Random();
        return random.ints(0, (poolSize)).limit(1).findFirst().getAsInt();
    }
}