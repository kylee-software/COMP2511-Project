package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Enemies.Zombie;
import unsw.loopmania.model.Entity;
import unsw.loopmania.model.PathPosition;

public class ZombiePitBuilding extends Building {

    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Produces a zombie every cycle of the path completed by the Character
     * @return a newly produced zombies
     */
    public Zombie spawnZombie(List<Pair<Integer, Integer>> orderedPath) {
        Pair<Integer, Integer> position = spawnPosition(orderedPath);

        Zombie zombie = new Zombie(new PathPosition(orderedPath.indexOf(position), orderedPath), 100, "Zombie");

        return zombie;
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
