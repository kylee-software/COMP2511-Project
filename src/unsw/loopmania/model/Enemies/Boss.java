package unsw.loopmania.model.Enemies;

import unsw.loopmania.model.MovingEntity;
import unsw.loopmania.model.PathPosition;

public class Boss extends MovingEntity {

    /**
     * Create a moving entity which moves up and down the path in position
     *
     * @param position represents the current position in the path
     * @param health
     * @param speed
     */
    public Boss(PathPosition position, int health, double speed) {
        super(position, health, speed);
    }

    @Override
    public int getDamage() {
        return 0;
    }
}
