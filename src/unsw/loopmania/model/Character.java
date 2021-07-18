package unsw.loopmania.model;

import unsw.loopmania.model.AttackStrategy.*;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {

    private AttackStrategy strategy;
    private static int health = 100;
    private static int baseDamage = 6;
    private static double speed = 2; // Ticks per tile

    // TODO: = potentially implement relationships between this class and other classes
    public Character(PathPosition position) {
        super(position, health, speed);
    }

    // Dont know if this is needed since its already implemented
    public void move() {
        // TODO: = need to implement this correctly and add javadoc
    }

    // IMPLEMENT OBSERVWRE PATTERN FOR BATTLE

    /**
     * Getter for damage of character (base + weapons)
     * @return damage
     */
    public int getDamage() {
        // TODO: account for weapons
        return baseDamage;
    }
    
}
