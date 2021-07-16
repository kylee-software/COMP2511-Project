package unsw.loopmania.model;

import unsw.loopmania.model.AttackStrategy.AttackStrategy;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {

    private AttackStrategy strategy;

    // TODO = potentially implement relationships between this class and other classes
    public Character(PathPosition position, int health) {
        super(position, health);
    }

    public void move() {
        // TODO = need to implement this correctly and add javadoc
    }

    // IMPLEMENT OBSERVWRE PATTERN FOR BATTLE

    public void takeDamage(int damage) {
        // TODO = need to implement this correctly and add javadoc
    }
    
}
