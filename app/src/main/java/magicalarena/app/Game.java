
package magicalarena.app;

import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import magicalarena.app.IGameEndListener;
import magicalarena.app.Player;
import magicalarena.app.IArena;
import magicalarena.app.Arena;

public class Game {
    private int id;
    private HashMap<Integer,Player> playerList;
    private final IArena fightArena;
    private ArrayList<IGameEndListener> listeners;

    public Game() {
        this.id = 0;
        playerList = new HashMap<Integer,Player>();
        this.fightArena = new Arena();
        listeners = new ArrayList<>();
    }

    public Game(IArena arena) {
        this.id = 0;
        playerList = new HashMap<Integer,Player>();
        this.fightArena = arena;
        listeners = new ArrayList<>();
    }

    public void addListener(IGameEndListener gameListener) {
        listeners.add(gameListener);
    }

    private void notifyGameEndListeners() {
        for(IGameEndListener listener: listeners) {
            listener.onGameEnded();
        }
    }

    public void addPlayer(int strength,int health,int attack) {
        
        try {
            Player player = new Player(this.id+1,health,strength,attack);
            playerList.put(this.id+1,player);
            System.out.println("Player has been created and assigned ID "+this.id+1);
            System.out.println(player);
            this.id++;
        } catch(IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public void fight(int player1,int player2) {
        if (player1 == player2) {
            System.err.println("Player can't fight with himself!");
            return;
        }
        if (!playerList.containsKey(player1)) {
            System.err.println("player "+player1+" is not created");
        }
        else if (!playerList.containsKey(player2)) {
            System.err.println("player "+player2+" is not created");
        }
        else {
            fightArena.fight(playerList.get(player1),playerList.get(player2));
            if(playerList.get(player1).getHealth() == 0 || playerList.get(player2).getHealth() == 0) {
                notifyGameEndListeners();
            }
        }
    }

    public void getPlayers() {
        System.out.println("All Active Player status!");
        for(int id: playerList.keySet()) {
            System.out.println(playerList.get(id));
        }
    }

    public Set getAvailablePlayerId() {
        return playerList.keySet();
    }
}