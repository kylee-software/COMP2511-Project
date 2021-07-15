package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.List;

public class ZombiePitBuilding extends Building implements CreateEntityBehaviour {

    private int zombieCastleCycle;

    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Produces zombies every cycle of the path completed by the Character
     * @param cycle the cycle the LoopManiaWorld is in
     * @return a list of newly produced zombies
     */
    public List<Entity> produceEntity(int cycle) {
        // TODO = need to implement this correctly and add javadoc
        return new ArrayList<>();
    }
}
