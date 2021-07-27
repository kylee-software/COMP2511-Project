package unsw.loopmania.model.Enemies;

import unsw.loopmania.model.PathPosition;

public class Doggie extends Boss {
    private int health = 100;
    private double speed = 4;

    /**
     * Create a moving entity which moves up and down the path in position
     *
     * @param position represents the current position in the path
     */
    public Doggie(PathPosition position) {
        super(position, health, speed);
    }
}
