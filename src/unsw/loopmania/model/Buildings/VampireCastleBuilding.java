package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * a basic form of building in the world
 */
public class VampireCastleBuilding extends Building implements CreateEntityBehaviour {

    private int vampireCastleCycle;

    // TODO = add more types of building, and make sure buildings have effects on entities as required by the spec
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Produces vampires every 5 cycles of the path completed by the Character
     * @param cycle the cycle the LoopManiaWorld is in
     * @return a list of newly produced vampires
     */
    public List<Entity> produceEntity(int cycle) {
        // TODO = need to implement this correctly and add javadoc
        return new ArrayList<>();
    }
}
