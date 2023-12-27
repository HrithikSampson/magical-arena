
package magicalarena.app;

import java.util.Scanner;
import magicalarena.app.Game;

public class GameControls implements IGameEndListener, IGameController{
    private final Game game;
    private boolean hasEnded;
    
    public GameControls() {
        game = new Game();
        hasEnded = false;
        game.addListener(this);
    }

    public GameControls(IArena arena) {
        game = new Game(arena);
        game.addListener(this);
        hasEnded = false;
    }
    
    @Override
    public void onGameEnded() {
        hasEnded = true;
    }

    public void playGame() {
        System.out.println("Game starts!");
        Scanner sc = new Scanner(System.in);

        while(!hasEnded) {
            try{
                System.out.println("Select your Choice!");
                System.out.println("1. Add a player.");
                System.out.println("2. Check Player Statuses.");
                System.out.println("3. Get All Player Ids");
                System.out.println("4. Enter 2 Players to fight in the arena");
                char ch = sc.next().charAt(0);
                System.out.println("Character taken:"+ch);
                if(sc.hasNextLine()){
                    sc.nextLine();
                }
                switch(ch) {
                    case '1':
                        System.out.print("Enter Health: ");
                        int health = sc.nextInt();

                        System.out.print("Enter Strength: ");
                        int strength = sc.nextInt();
                        
                        System.out.print("Enter Attack: ");
                        int attack = sc.nextInt();
                        sc.nextLine();

                        game.addPlayer(strength,health,attack);
                    break;
                    case '2':
                        game.getPlayers();
                    break;
                    case '3':
                        System.out.println("Players in the game: ");
                        System.out.println(game.getAvailablePlayerId());
                    break;
                    case '4':
                        System.out.println("Enter ID of player 1: ");
                        int playerIdOne = sc.nextInt();
                        System.out.println("Enter ID of player 2: ");
                        int playerIdTwo = sc.nextInt();
                        game.fight(playerIdOne,playerIdTwo);
                    break;
                    default:
                        System.err.println("Incorrect Input!");
                }
            } catch(Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("Game has Ended.");
    }
}