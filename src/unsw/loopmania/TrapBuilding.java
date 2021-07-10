package unsw.loopmania;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.List;

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
