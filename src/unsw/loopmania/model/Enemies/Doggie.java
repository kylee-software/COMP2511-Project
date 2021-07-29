package unsw.loopmania.model.Enemies;

import unsw.loopmania.model.PathPosition;

public class Doggie extends Enemy {
    private int health = 100;
    private final double speed = 4;
    private final int damage = 20;

    /**
     * Constructor for Doggie
     * @param position - current position on map
     */
    public Doggie(PathPosition position) {
        super(position, health, damage, speed);
    }

    // TODO: need to complete these methods
    @Override
    public int getExpReward() {
        return 0;
    }

    @Override
    public int getGoldReward() {
        return 0;
    }

    @Override
    public int getSupportRadius() {
        return 0;
    }

    @Override
    public int getBattleRadius() {
        return 0;
    }
}
