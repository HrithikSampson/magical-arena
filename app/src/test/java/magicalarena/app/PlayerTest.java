package magicalarena.app;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
import magicalarena.app.Player;
import org.junit.Rule;

public class PlayerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void negativeHealthCreation() {
        thrown.expect(IllegalArgumentException.class);
        new Player(1, -10, 5, 10);
    }
    @Test
    public void negetiveStrengthCreation() {
        thrown.expect(IllegalArgumentException.class);
        new Player(1, 10, -5, 10);
    }
    @Test
    public void negetiveAttackCreation() {
        thrown.expect(IllegalArgumentException.class);
        new Player(1, 10, 5, -10);
    }
    @Test
    public void testPlayerCreation() {
        Player player = new Player(4, 100, 20, 30);
        assertEquals(4, player.getId());
        assertEquals(100, player.getHealth());
        assertEquals(20, player.getStrength());
        assertEquals(30, player.getAttack());
    }

    @Test
    public void testReduceHealth() {
        Player player = new Player(1, 100, 20, 30);

        player.reduceHealth(10);
        assertEquals(90, player.getHealth());

        player.reduceHealth(120);
        assertEquals(0, player.getHealth());

        player.reduceHealth(-10);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testToString() {
        Player player = new Player(1, 100, 20, 30);
        String expected = "Player 1 { \n\thealth: 100\n\tattack: 30\n\tstrength: 20\n}";
        assertEquals(expected, player.toString());
    }
}