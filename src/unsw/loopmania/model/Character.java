package unsw.loopmania.model;

import unsw.loopmania.model.AttackStrategy.*;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {

    private static AttackStrategy strategy = new BasicAttack();
    private static int health = 100;
    private static int baseDamage = 6;
    private static double speed = 2; // Ticks per tile
    private static int stunnedCycle = 1;
    private int remainingStunnedCycles;


    public Character(PathPosition position) {
        super(position, health, speed);
        this.remainingStunnedCycles = 0;
    }

    /**
     * Getter for damage of character (base + weapons)
     * @return damage
     */
    public int getDamage() {
        return baseDamage;
    }

    /**
     * Getter for attack strategy
     */
    public AttackStrategy getAttackStrategy() {
        return strategy;
    }

    /**
     * Setter for stunned cycles, default 1
     */
    public void setStunnedCycles() {
        this.remainingStunnedCycles = stunnedCycle;
    }
    
        /**
     * Getter for remaining stunned cycles
     * @return remaining stunned cycles
     */
    public int getStunnedCycle() {
        return remainingStunnedCycles;
    }

    public void reduceStunnedCycle() {
        this.remainingStunnedCycles -= 1;
    }
}
