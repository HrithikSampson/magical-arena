
import magicalarena.app.Player;
import magicalarena.app.Arena;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Math.class)
public class ArenaTest {

    @Test
    public void testFight() {
        Player p1 = new Player(1, 90, 50, 20);
        Player p2 = new Player(2, 100, 10, 25);

        mockStatic(Math.class);
        when(Math.random()).thenReturn(0.2);

        Arena arena = new Arena() {
            @Override
            protected int dieRoll() {
                return 2;
            }
        };
        arena.fight(p1, p2);

        assertEquals(90, p1.getHealth());
        assertEquals(80, p2.getHealth());

        arena.fight(p1, p2);

        assertEquals(90, p1.getHealth());
        assertEquals(60, p2.getHealth());
    }
}