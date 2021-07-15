package unsw.loopmania.model.Items.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Equipped or unequipped Staff in the backend world
 */
public class Staff extends BasicItem {
    
    private static int buyPrice = 50;
    private int damage = 3;
    private int tranceChance = 40;

    /**
     * Constructor for Staff
     * @param x - x-coordinate for Staff
     * @param y - y-coordinate for Staff
     */
    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, buyPrice);
    }

    /**
     * Getter for damage
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Getter for chance of entrancing enemy
     * @return tranceChance (%)
     */
    public int getTranceChance() {
        return tranceChance;
    }
}
