package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * The moving entity
 */
public abstract class MovingEntity extends Entity {

    /**
     * object holding position in the path
     */
    private PathPosition position;
    private int health;

    /**
     * Create a moving entity which moves up and down the path in position
     * @param position represents the current position in the path
     */
    public MovingEntity(PathPosition position, int health) {
        super();
        this.position = position;
        this.health = health;
    }

    /**
     * move clockwise through the path
     */
    public void moveDownPath() {
        position.moveDownPath();
    }

    /**
     * move anticlockwise through the path
     */
    public void moveUpPath() {
        position.moveUpPath();
    }

    public SimpleIntegerProperty x() {
        return position.getX();
    }

    public SimpleIntegerProperty y() {
        return position.getY();
    }

    public int getX() {
        return x().get();
    }

    public int getY() {
        return y().get();
    }

    /**
     * Setter for health of moving entity
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Getter for health of moving entity
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter for damage of entity
     * @return damage
     */
    public abstract int getDamage();

    public boolean isDead() {
        // TODO = need to implement this correctly and add javadoc
        return false;
    }
}
