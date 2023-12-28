import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import magicalarena.app.IArena;
import magicalarena.app.Arena;
import magicalarena.app.IGameEndListener;
import magicalarena.app.Game;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertTrue;
import java.util.Set;


public class GameTest {

    @Mock
    private IArena arena;

    @Mock
    private IGameEndListener listener;

    private Game game;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
        game = new Game(arena);
        game.addListener(listener);
    }

    @Test
    public void testAddPlayer() {
        game.addPlayer(1, 100, 5);
        game.addPlayer(2,100,5);
    }

    @Test
    public void testFightWithValidPlayers() {
        
        game.fight(1, 2);

        verify(listener, never()).onGameEnded();
    }

    @Test
    public void testFightWithSamePlayer() {
        game.fight(1, 1);
        verify(arena, times(0)).fight(any(), any());

    }

    @Test
    public void testFightWithUnknownPlayer() {
        game.fight(1, 3);
        verify(arena, times(0)).fight(any(), any());
    }

    @Test
    public void testPlayersInGame() {
        
        game.addPlayer(1, 100, 5);
        game.addPlayer(2,100,5);
        System.out.println(game.getAvailablePlayerId());
        assertTrue((game.getAvailablePlayerId()).contains(1) && (game.getAvailablePlayerId()).contains(2));
    }
}