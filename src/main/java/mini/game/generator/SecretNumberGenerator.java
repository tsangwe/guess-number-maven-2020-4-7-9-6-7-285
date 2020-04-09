package mini.game.generator;

import java.util.ArrayList;
import java.util.Random;

public class SecretNumberGenerator implements NumberGenerator {
    private static final int NUMBER_POOL_RANGE = 9;
    private static final int SECRET_NUMBER_LENGTH = 4;

    private Integer[] secretNumbers;


    public SecretNumberGenerator() {
        genNewSecretNumber();
    }

    @Override
    public Integer[] getSecretNumbers() {
        return this.secretNumbers;
    }

    public void genNewSecretNumber() {
        Integer[] newSecretNumberArray = new Integer[SECRET_NUMBER_LENGTH];

        // Create number pool
        ArrayList<Integer> numberPool = new ArrayList<>();
        for (int count = 0; count <= NUMBER_POOL_RANGE; count++) {
            numberPool.add(count);
        }

        // Build up secretNumbers
        for (int currIndex = 0; currIndex < newSecretNumberArray.length; currIndex++) {
            newSecretNumberArray[currIndex] = numberPool.remove(pickRandomIndexFromNumberPool(numberPool.size()));
        }

        this.secretNumbers = newSecretNumberArray;
    }

    private int pickRandomIndexFromNumberPool(int poolSize) {
        Random random = new Random();
        return random.ints(0, (poolSize)).limit(1).findFirst().getAsInt();
    }
}