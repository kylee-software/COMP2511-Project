package unsw.loopmania.model;

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
    private double speed;

    /**
     * Create a moving entity which moves up and down the path in position
     * @param position represents the current position in the path
     */
    public MovingEntity(PathPosition position, int health, double speed) {
        super();
        this.position = position;
        this.health = health;
        this.speed = speed;
    }

    /**
     * 
     * @return - true if entity is of a Boss type. Default false, overriden in boss interface. 
     */
    public Boolean isBoss() {
        //default false
        return false;
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

    public void reduceHealth(int damage) {
        this.health = Math.max(getHealth() - damage, 0);
    }

    /**
     * Getter for speed of moving entity
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Checks if entity legally is dead
     */
    public boolean isDead() {
        return this.health <= 0;
    }
    
    public abstract int getDamage();

    //todo: gainHealth should have a max cap depending on the maxhealth of each entity.
    public void gainHealth(int healthBonus) {
        this.health = Math.min(getHealth() + healthBonus, 100);
    }

    /**
     * Check whether Character/Enemy is alive
     * @param void 
     * @return true if Character/Enemy is alive 
     */
    public boolean isAlive() {
        if (getHealth() > 0) return true;
        else return false;
    }
}
