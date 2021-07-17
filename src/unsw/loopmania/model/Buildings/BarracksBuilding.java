package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.AlliedSoldier;
import unsw.loopmania.model.PathPosition;

public class BarracksBuilding extends Building {

    private PathPosition pathPosition;

    public BarracksBuilding (PathPosition pathPosition) {
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
     * Creates an allied soldier when Character passes over barracks
     * @param x x coordinate of allied soldier
     * @param y y coordinate of allied soldier
     * @return allied soldier
     */
    public AlliedSoldier spawnAlliedSoldier(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        int health = 100;
        return new AlliedSoldier(x, y, health);
    }
    
}