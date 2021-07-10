package unsw.loopmania;
import javafx.beans.property.SimpleIntegerProperty;

public class ZombiePitBuilding extends Building implements CreateEntityBehaviour {

    private int zombieCastleCycle;

    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public void spawnEntity() {
        // TODO = need to implement this correctly and add javadoc
    }
}
