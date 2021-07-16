package unsw.loopmania.model.Enemies;

import java.util.List;

import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.Cards.Card;

public class Zombie extends BasicEnemy {

    private int expReward;
    private int goldReward;
    private List<Card> cardReward;
    private int battleRadius;
    private int supportRadius;
    private double speed;

    private AttackStrategy strategy;
    private int damage;


    public Zombie(PathPosition position, int health, String type) {
        super(position, health, type);
    }

    @Override
    public void move() {
        super.move();
    }

    public int getExpReward() {
        return expReward;
    }

    public int getGoldReward() {
        return goldReward;
    }

    public int getBattleRadius() {
        return battleRadius;
    }

    public int getSupportRadius() {
        return supportRadius;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }
}
