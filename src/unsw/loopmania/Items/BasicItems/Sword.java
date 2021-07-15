package unsw.loopmania.Items.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Equipped or unequipped sword in the backend world
 */
public class Sword extends BasicItem {
    
    private static int buyPrice = 40;
    private int damage = 10;
    private static String type = "Weapon";

    /**
     * Constructor for Sword
     * @param x - x-coordinate for Sword
     * @param y - y-coordinate for Sword
     */
    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, buyPrice, type);
    }

    /**
     * Getter for damage
     * @return damage
     */
    public int getDamage() {
        return damage;
    }
}
