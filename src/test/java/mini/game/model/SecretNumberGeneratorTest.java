package mini.game.model;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;

public class SecretNumberGeneratorTest {

    SecretNumberGenerator secretNumberGenerator;

    @Test
    public void test_getSecretNumbers_no_duplicate() {
        secretNumberGenerator = new SecretNumberGenerator();
        Integer[] secretNumbers = secretNumberGenerator.getSecretNumbers();
        
        Long distinctCount = Stream.of(secretNumbers).distinct().count();

        assertEquals(false, secretNumbers.length != distinctCount);
    }

    @Test
    public void test_getSecretNumbers_number_in_range() {
        secretNumberGenerator = new SecretNumberGenerator();
        Integer[] secretNumbers = secretNumberGenerator.getSecretNumbers();
        Boolean isInRange = true;

        for (int number: secretNumbers) {
            if (number < 0 || number > 9) {
                isInRange = false;
            }
        }

        assertEquals(true, isInRange);
    }
}