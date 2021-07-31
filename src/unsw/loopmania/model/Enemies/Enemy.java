package unsw.loopmania.model.Enemies;

import unsw.loopmania.model.MovingEntity;
import unsw.loopmania.model.PathPosition;

import java.util.Random;

/**
 * a basic form of enemy in the backend world
 */
public abstract class Enemy extends MovingEntity {

    private String type;
    private int damage;

    /**
     * Constructor for Basic Enemy
     * @param position - position on map
     * @param health
     * @param damage
     */
    public Enemy(PathPosition position, int health, int damage, double speed) {
        super(position, health, speed);
        this.damage = damage;
    }

    /**
     * move the enemy
     */
    public void move(){
        // this basic enemy moves in a random direction... 25% chance up or down, 50% chance not at all...
        int directionChoice = (new Random()).nextInt(4);
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

    public abstract int getExpReward();
    public abstract int getGoldReward();
    public abstract int getSupportRadius();
    public abstract int getBattleRadius();

}
