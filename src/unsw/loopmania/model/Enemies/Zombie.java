package unsw.loopmania.model.Enemies;

import java.util.List;

import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.Cards.Card;

public class Zombie extends BasicEnemy {

    private static int expReward = 300;
    private static int goldReward = 20;
    private List<Card> cardReward; // TODO:
    private static int battleRadius = 2;
    private static int supportRadius = 2;
    private static double speed = 4; // Ticks per tile
    private AttackStrategy strategy; // TODO:
    private static int damage = 14;
    private static int health = 20;

    /**
     * Constructor for Zombie
     * @param position - current position on map
     * @param health
     * @param type
     */
    public Zombie(PathPosition position, String type) {
        super(position, health, type, damage, type, speed);
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

}
