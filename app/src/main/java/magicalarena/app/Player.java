
package magicalarena.app;

public class Player {
    private int health;
    private int strength;
    private int attack;
    private int id;
    public Player(int id,int health,int strength,int attack) throws IllegalArgumentException {
        this.id = id;
        if(strength <= 0) {
            throw new IllegalArgumentException("Strength has to be positive!");
        }
        if(health <= 0) {
            throw new IllegalArgumentException("Health has to be positive!");
        }
        if(attack <= 0) {
            throw new IllegalArgumentException("Attack has to be positive!");
        }
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
    public int getId() {
        return id;
    }
    public int getHealth() {
        return health;
    }
    public int getStrength() {
        return strength;
    }
    public int getAttack() {
        return attack;
    }
    public void reduceHealth(int damage) {
        if(damage < 0) {
            return;
        }
        if(damage > this.health) {
            this.health = 0;
            return;
        }
        this.health = this.health - damage;
    }

    @Override
    public String toString() {
        return "Player "+this.id+" { \n" +
            "\thealth: "+health+"\n" +
            "\tattack: "+attack+"\n" +
            "\tstrength: "+strength+"\n" +
        "}";
    }
}