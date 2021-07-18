package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.BasicEnemy;

public class TrapBuilding extends Building {

    private PathPosition pathPosition;

    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public TrapBuilding(PathPosition pathPosition) {
        super(pathPosition.getX(), pathPosition.getY());
        this.pathPosition = pathPosition;
    }

    public void setPathPosition(PathPosition pathPosition) {
        this.pathPosition = pathPosition;
    }

    public PathPosition getPathPosition() {
        return pathPosition;
    }

    /**
     * Damage an enemy's health when the enemy passes over the trap
     * @param enemy Enemy
     */
    public int damageEnemy(BasicEnemy enemy) {
        int damage = 10;
        enemy.reduceHealth(damage);
        return enemy.getHealth();
    }
}
