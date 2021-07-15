package unsw.loopmania;

import de.schlichtherle.truezip.socket.IOCache;

import java.util.Random;

/**
 * a basic form of enemy in the backend world
 */
public abstract class BasicEnemy extends MovingEntity {

    private String type;
    private AttackStrategy strategy = new BasicAttack();
    private int damage;

    /**
     * Constructor for Basic Enemy
     * @param position - position on map
     * @param health
     * @param damage
     * @param type
     */
    public BasicEnemy(PathPosition position, int health, int damage, String type, double speed) {
        super(position, health, speed);
        this.type = type;
        this.damage = damage;
    }

    /**
     * move the enemy
     */
    public void move(){
        // TODO: = modify this, since this implementation doesn't provide the expected enemy behaviour
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(2);
        if (directionChoice == 0){
            moveUpPath();
        }
        else if (directionChoice == 1){
            moveDownPath();
        }
    }

    public String getType() {
        return type;
    }

    /**
     * Getter for damage
     * @return damage
     */
    public int getDamage() {
        return this.damage;
    }

    public abstract int getEXPReward();
    public abstract int getGoldReward();
    public abstract int getSupportRadius();
    public abstract int getBattleRadius();

}
