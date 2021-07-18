package unsw.loopmania.model.Enemies;

import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.AttackStrategy.VampireAttack;

public class Vampire extends BasicEnemy {

    private static int expReward = 800;
    private static int goldReward = 50;
    private static int battleRadius = 2;
    private static int supportRadius = 3;
    private static double speed = 1; // Ticks per tile
    private static AttackStrategy strategy = new VampireAttack();
    private static int damage = 25;
    private static int health = 50;
    private static int critChance = 40;

    /**
     * Constructor for Vampire
     * @param position - current position on map
     * @param health
     * @param type
     */
    public Vampire(PathPosition position) {
        super(position, health, damage, speed);
    }

    @Override
    public void move() {
        super.move();
    }

     /**
     * Getter for EXP reward when killed
     * @return EXP reward
     */
    public int getExpReward() {
        return expReward;
    }

    /**
     * Getter for gold reward when killed
     * @return gold reward
     */
    public int getGoldReward() {
        return goldReward;
    }

    /**
     * Getter for battle radius of slug
     * @return battle radius (tiles)
     */
    public int getBattleRadius() {
        return battleRadius;
    }

    /**
     * Getter for support radius of slug
     * @return support radius (tiles)
     */
    public int getSupportRadius() {
        return supportRadius;
    }

    public int getCritChance() {
        return critChance;
    }

    /**
     * Getter for attack strategy
     */
    @Override
    public AttackStrategy getAttackStrategy() {
        return strategy;
    }

    // TODO: stub for vampire running from campfire
    public boolean runFromCampfire() {
        return false;
    }
}
