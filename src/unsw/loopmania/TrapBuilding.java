package unsw.loopmania;

import java.util.List;

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


    public void damageEnemy(BasicEnemy enemy) {
        // TODO = need to implement this correctly and add javadoc
    }
}
