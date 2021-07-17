package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.Vampire;

/**
 * a basic form of building in the world
 */
public class VampireCastleBuilding extends Building {

    // DONE = add more types of building, and make sure buildings have effects on entities as required by the spec
    public VampireCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Spawn vampires every 5 cycles of the path completed by the Character
     * @param cycle number of path cycles the Character had completed
     * @param position position where vampire is spawned
     * @return vampire
     */
    public Vampire spawnVampire(int cycle, PathPosition position) {
        if (cycle % 5 == 0) {
            int health = 100;
            String type = "Vampire";
            return new Vampire(position, health, type);
        }
        return null;
    }
}
