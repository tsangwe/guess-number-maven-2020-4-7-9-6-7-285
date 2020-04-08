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
    public void test_isValidateInput_when_input_length_too_long() {
        boolean actualOutput = agent.isValidateInput("12345");
        assertEquals(false, actualOutput);
    }

    @Test
    public void test_isValidateInput_when_input_length_too_short() {
        boolean actualOutput = agent.isValidateInput("12");
        assertEquals(false, actualOutput);
    }
}
    