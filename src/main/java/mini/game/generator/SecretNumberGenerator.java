package mini.game.generator;

import mini.game.exception.FailToGenerateRandomIndexException;

import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.Random;

public class SecretNumberGenerator implements NumberGenerator {
    private static final int NUMBER_POOL_RANGE = 9;
    private static final int SECRET_NUMBER_LENGTH = 4;
    private static final int RANDOM_NUMBER_BEGIN_INCLUDE = 0;

    private Integer[] secretNumbers;


    public SecretNumberGenerator() {
        try {
            genNewSecretNumber();
        } catch (FailToGenerateRandomIndexException failToGenerateRandomIndexException) {
            failToGenerateRandomIndexException.printStackTrace();
        }
    }

    @Override
    public Integer[] getSecretNumbers() {
        return this.secretNumbers;
    }

    public void genNewSecretNumber() throws FailToGenerateRandomIndexException {
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

    private int pickRandomIndexFromNumberPool(int poolSize) throws FailToGenerateRandomIndexException {
        Random random = new Random();
        OptionalInt randomNumberOptional = random.ints(RANDOM_NUMBER_BEGIN_INCLUDE, (poolSize)).limit(1).findFirst();
        if (randomNumberOptional.isPresent()) return randomNumberOptional.getAsInt();
        throw new FailToGenerateRandomIndexException();
    }
}