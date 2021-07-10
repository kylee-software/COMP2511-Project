package unsw.loopmania;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

public class TrapBuilding extends Building {

    public TrapBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
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
