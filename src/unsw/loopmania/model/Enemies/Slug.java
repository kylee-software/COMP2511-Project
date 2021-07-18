package unsw.loopmania.model.Enemies;

import java.util.List;

import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.AttackStrategy.SlugAttack;
import unsw.loopmania.model.Cards.Card;

public class Slug extends BasicEnemy {

    private static int expReward = 100;
    private static int goldReward = 10;
    private List<Card> cardReward; // TODO:
    private static int battleRadius = 1;
    private static int supportRadius = 1;
    private static double speed = 3; // Ticks per tile
    private static AttackStrategy strategy = new SlugAttack();
    private static int damage = 7;
    private static int health = 10;

    /**
     * Constructor for slug
     * @param position - current position on map
     */
    public Slug(PathPosition position) {
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

    /**
     * Getter for attack strategy
     */
    @Override
    public AttackStrategy getAttackStrategy() {
        return strategy;
    }
}
