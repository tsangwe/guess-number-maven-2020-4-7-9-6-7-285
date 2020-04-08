package mini.game.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;   
    
public class AgentTest {
    private Agent agent = new Agent();
    @Test
    public void test_isPlayerWin_when_player_win_return_true() {
        boolean actualOutput = agent.isPlayerWin("4A0B");
        assertEquals(true, actualOutput);
    }

    @Test
    public void test_isPlayerWin_when_player_lose_return_false() {
        boolean actualOutput = agent.isPlayerWin("2A0B");
        assertEquals(false, actualOutput);
    }

    @Test
    public void test_isValidateInput_when_input_length_too_long_return_false() {
        boolean actualOutput = agent.isValidateInput("12345");
        assertEquals(false, actualOutput);
    }

    @Test
    public void test_isValidateInput_when_input_length_too_short_return_false() {
        boolean actualOutput = agent.isValidateInput("12");
        assertEquals(false, actualOutput);
    }

    @Test
    public void test_isValidateInput_when_input_contains_space_return_false() {
        boolean actualOutput = agent.isValidateInput("123 4");
        assertEquals(false, actualOutput);
    }

    @Test
    public void test_isValidateInput_when_input_not_parsable_to_number_return_false() {
        boolean actualOutput = agent.isValidateInput("123a");
        assertEquals(false, actualOutput);
    }

    @Test
    public void test_isValidateInput_when_input_has_duplicates_return_false() {
        boolean actualOutput = agent.isValidateInput("1123");
        assertEquals(false, actualOutput);
    }

    @Test
    public void test_isValidateInput_when_input_is_valid_return_true() {
        boolean actualOutput = agent.isValidateInput("1234");
        assertEquals(true, actualOutput);
    }

    @Test
    public void test_getFeedback_when_input_match_nothing_return_0A0B() {
        Integer[] secretNumber = new Integer[] {1, 2, 3, 4};
        String actualFeedback = agent.getFeedback("5678", secretNumber);
        assertEquals("0A0B", actualFeedback);
    }

    @Test
    public void test_getFeedback_when_input_match_char_return_0A2B() {
        Integer[] secretNumber = new Integer[] {1, 2, 3, 4};
        String actualFeedback = agent.getFeedback("2356", secretNumber);
        assertEquals("0A2B", actualFeedback);
    }

    @Test
    public void test_getFeedback_when_input_match_2_position_return_2A0B() {
        Integer[] secretNumber = new Integer[] {1, 2, 3, 4};
        String actualFeedback = agent.getFeedback("1256", secretNumber);
        assertEquals("2A0B", actualFeedback);
    }

    @Test
    public void test_getFeedback_when_input_match_1_position_2_char_but_wrong_position_return_1A2B() {
        Integer[] secretNumber = new Integer[] {1, 2, 3, 4};
        String actualFeedback = agent.getFeedback("1345", secretNumber);
        assertEquals("1A2B", actualFeedback);
    }

    @Test
    public void test_getFeedback_when_input_match_4_position_return_4A0B() {
        Integer[] secretNumber = new Integer[] {1, 2, 3, 4};
        String actualFeedback = agent.getFeedback("1234", secretNumber);
        assertEquals("4A0B", actualFeedback);
    }
    
}
    