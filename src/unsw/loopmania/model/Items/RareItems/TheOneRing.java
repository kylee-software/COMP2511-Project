package unsw.loopmania.model.Items.RareItems;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.model.Character;

/**
 * Equipped or unequipped The One Ring in the backend world
 */
public class TheOneRing extends RareItem {

    /**
     * Constructor for TheOneRing
     * @param x - x-coordinate for TheOneRing
     * @param y - y-coordinate for TheOneRing
     */
    public TheOneRing(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    /**
     * Revives given character on death
     * @param c - character to revive
     */
    public void reviveCharacter(Character c) {
        if (c.getHealth() == 0) {
            c.setHealth(100);
        }
    }
}
