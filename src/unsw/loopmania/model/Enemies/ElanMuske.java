package unsw.loopmania.model.Enemies;

import unsw.loopmania.model.PathPosition;

public class ElanMuske extends Enemy {
    private final double speed = 5;
    private int health = 100;
    private final int damage = 20;

    /**
     * Create a moving entity which moves up and down the path in position
     *
     * @param position represents the current position in the path
     */
    public ElanMuske(PathPosition position) {
        super(position, health, damage, speed);
    }

    // TODO: need to complete this
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
