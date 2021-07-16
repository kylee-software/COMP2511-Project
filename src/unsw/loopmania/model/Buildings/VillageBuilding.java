package unsw.loopmania.model.Buildings;

import unsw.loopmania.model.PathPosition;

public class VillageBuilding extends Building {

    private int healthBonus;
    private PathPosition pathPosition;

    public VillageBuilding (PathPosition pathPosition) {
        super(pathPosition.getX(), pathPosition.getY());
        this.pathPosition = pathPosition;
    }

    public void setPathPosition(PathPosition pathPosition) {
        this.pathPosition = pathPosition;
    }

    public PathPosition getPathPosition() {
        return pathPosition;
    }

    public boolean checkForCharacter(Character character) {
        // TODO = need to implement this correctly and add javadoc
        return false;
    }


    // OBSERVER PATTERN

    public void addHealth(Character character) {
        // TODO = need to implement this correctly and add javadoc
    }

}
