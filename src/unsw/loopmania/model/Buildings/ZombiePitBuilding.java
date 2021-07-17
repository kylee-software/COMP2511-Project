package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.PathPosition;
import unsw.loopmania.model.Enemies.Zombie;

public class ZombiePitBuilding extends Building {

    public ZombiePitBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Spawn zombie every cycle of the path completed by the Character
     * @param cycle number of path cycles the Character had completed
     * @param position position where zombie is spawned
     * @return zombie
     */
    public Zombie spawnZombie(PathPosition position) {
        int health = 100;
        String type = "Zombie";
        return new Zombie(position, health, type);
    }
}
