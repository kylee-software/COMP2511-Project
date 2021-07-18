package unsw.loopmania.model;

import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.AttackStrategy.BasicAttack;

public class AlliedSoldier extends MovingEntity {

    private static int health = 100;
    private int max;
    private static int damage = 6;
    private static double speed = 0;
    private static AttackStrategy strategy = new BasicAttack();

    public AlliedSoldier(PathPosition position) {
        super(position, health, speed);
    }

    /**
     * Getter for health
     */
    public int getHealth() {
        return health;
    }

    public int getMax() {
        return max;
    }

    /**
     * Setter for health
     */
    public void setHealth(int newHealth) {
        health = newHealth;
    }

    /**
     * Checks if allied soldier is dead
     */
    public boolean isDead() {
        return getHealth() == 0;
    }

    /**
     * Getter for allied soldier damage
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * Getter for attack strategy
     */
    @Override
    public AttackStrategy getAttackStrategy() {
        return strategy;
    }
}
