package unsw.loopmania;

import java.util.List;

public class Slug extends BasicEnemy {

    private static int expReward = 100;
    private static int goldReward = 10;
    private List<Card> cardReward; // TODO:
    private static int battleRadius = 1;
    private static int supportRadius = 1;
    private double speed; // TODO:

    private AttackStrategy strategy;
    private static int damage = 7;


    public Slug(PathPosition position, int health, String type) {
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
