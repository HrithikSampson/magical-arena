package magicalarena.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import magicalarena.app.Player;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        assertThrows(IllegalArgumentException.class, () -> new Player(1, -10, 5, 10));
        assertThrows(IllegalArgumentException.class, () -> new Player(2, 10, -5, 10));
        assertThrows(IllegalArgumentException.class, () -> new Player(3, 10, 5, -10));

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