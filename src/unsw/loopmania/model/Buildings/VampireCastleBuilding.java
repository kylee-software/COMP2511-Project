package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Enemies.Vampire;
import unsw.loopmania.model.Enemies.Zombie;
import unsw.loopmania.model.Entity;
import unsw.loopmania.model.PathPosition;

import java.util.ArrayList;
import java.util.List;

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
    public Vampire spawnVampire(int cycle, PathPosition pathPosition) {

        if (cycle % 5 == 0 && cycle >= 1 ) {
            return new Vampire(pathPosition);
        }
        return null;
    }

    };
}
