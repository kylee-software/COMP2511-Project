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
     * Produces a vampire every 5 cycles of the path completed by the Character
     * @return a newly produced vampires
     */
    public Vampire spawnVampire(List<Pair<Integer, Integer>> orderedPath) {
        Pair<Integer, Integer> position = spawnPosition(orderedPath);

        Vampire vampire = new Vampire(new PathPosition(orderedPath.indexOf(position), orderedPath));

        return vampire;
    }

    private Pair<Integer, Integer> spawnPosition(List<Pair<Integer, Integer>> orderedPath) {

        int x = getX();
        int y = getY();

        Pair<Integer, Integer> upPostion  = new Pair<Integer, Integer>(x - 1, y);
        Pair<Integer, Integer> downPostion  = new Pair<Integer, Integer>(x + 1, y);
        Pair<Integer, Integer> leftPostion  = new Pair<Integer, Integer>(x, y - 1);
        Pair<Integer, Integer> rightPostion  = new Pair<Integer, Integer>(x, y + 1);

        if (orderedPath.indexOf(upPostion) != -1) {
            return upPostion;
        } else if (orderedPath.indexOf(downPostion != -1)) {
            return downPostion;
        } else if (orderedPath.indexOf(leftPostion != -1)) {
            return leftPostion;
        } else if (orderedPath.indexOf(rightPostion != -1)) {
            return rightPostion;
        } else {
            return null;
        }

    };
}
