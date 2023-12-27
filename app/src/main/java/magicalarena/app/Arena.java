
package magicalarena.app;

import magicalarena.app.IArena;
import magicalarena.app.Player;


public class Arena implements IArena{
    
    @Override
    public void fight(Player p1, Player p2) {
        Player firstAttacker = null;
        Player secondAttacker = null;
        if(p1.getHealth()<p2.getHealth()) {
            firstAttacker = p1;
            secondAttacker = p2;
        }
        else {
            firstAttacker = p2;
            secondAttacker = p1;
        }
        System.out.println("Attacker "+firstAttacker.getId()+" attacks "+secondAttacker.getId());
        int attackPoints = dieRoll() * firstAttacker.getAttack();
        int defendPoints = dieRoll() * secondAttacker.getStrength();
        System.out.println("First Attack!");
        System.out.println("Attack: "+attackPoints);
        System.out.println("Defence: "+defendPoints);
        secondAttacker.reduceHealth(attackPoints - defendPoints);
        System.out.println("Defender Status!");
        System.out.println(secondAttacker);
        if(secondAttacker.getHealth() == 0) {
            return;
        }
        attackPoints = dieRoll() * secondAttacker.getAttack();
        defendPoints = dieRoll() * firstAttacker.getStrength();
        System.out.println("Second Attack!");
        System.out.println("Attack: "+attackPoints);
        System.out.println("Defence: "+defendPoints);
        firstAttacker.reduceHealth(attackPoints - defendPoints);
        System.out.println("Defender Status!");
        System.out.println(firstAttacker);
    }
    private int dieRoll() {
        return ((int)(Math.random() * 6) + 1);
    }
}