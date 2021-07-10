package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class VillageBuilding extends Building {

    private int healthBonus;

    public VillageBuilding (SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
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
