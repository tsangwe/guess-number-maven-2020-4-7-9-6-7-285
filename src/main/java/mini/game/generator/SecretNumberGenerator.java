package mini.game.generator;

import java.util.concurrent.ThreadLocalRandom;

public class SecretNumberGenerator implements NumberGenerator {
    private static final int NUMBER_POOL_RANGE = 9;
    private static final int SECRET_NUMBER_LENGTH = 4;
    private static final int RANDOM_NUMBER_BEGIN_INCLUDE = 0;

    private Integer[] secretNumbers;


    public SecretNumberGenerator() {
        genNewSecretNumber();
    }

    @Override
    public Integer[] getSecretNumbers() {
        return this.secretNumbers;
    }

    public void genNewSecretNumber() {
        secretNumbers = ThreadLocalRandom.current().ints(RANDOM_NUMBER_BEGIN_INCLUDE, NUMBER_POOL_RANGE)
                .distinct().limit(SECRET_NUMBER_LENGTH).boxed().toArray(Integer[]::new);
    }
}