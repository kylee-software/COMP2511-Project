package unsw.loopmania.model;

import unsw.loopmania.model.AttackStrategy.AttackStrategy;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {

    private AttackStrategy strategy;
    private int health;

    // TODO = potentially implement relationships between this class and other classes
    public Character(PathPosition position) {
        super(position);
        this.health = 100;
    }

    // Dont know if this is needed since its already implemented
    public void move() {
        // TODO = need to implement this correctly and add javadoc
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

	public void gainHealth(int healthBonus) {
        this.health = Math.min(getHealth() + healthBonus, 100);
    }

    public boolean isDead() {
        return getHealth() == 0;
    }

    // IMPLEMENT OBSERVWRE PATTERN FOR BATTLE
    
    public void takeDamage(int damage) {
        this.health = Math.max(getHealth() - damage, 0);
    }
    
}
