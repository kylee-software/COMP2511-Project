package unsw.loopmania.model.Buildings;

import java.util.List;

import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.BasicEnemy;

public class TrapBuilding extends Building {

    private PathPosition pathPosition;

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

    // OBSERVER PATTERN

    public boolean checkForEnemy(List<BasicEnemy> enemies) {
        // TODO = need to implement this correctly and add javadoc
        return false;
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
