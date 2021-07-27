package unsw.loopmania.model.Enemies;

import unsw.loopmania.model.PathPosition;

public class ElanMuske extends Boss {
    private double speed = 5;
    private int health = 100;

    /**
     * Create a moving entity which moves up and down the path in position
     *
     * @param position represents the current position in the path
     */
    public ElanMuske(PathPosition position) {
        super(position, health, speed);
    }
}
