package mini.game.model;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.Test;   
    
public class AgentTest {
    private Agent agent = new Agent();
    @Test
    public void test_isPlayerWin_when_player_win_return_true() {
        boolean actualOutput = agent.isPlayerWin("4A0B");
        assertEquals(true, actualOutput);
    }
}
    