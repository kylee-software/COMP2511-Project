package unsw.loopmania.Items.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Equipped or unequipped stake in the backend world
 */
public class Stake extends BasicItem {
    
    private static int buyPrice = 100;
    private int damage = 5;
    private int vampireDamage = 25;
    private static String type = "Weapon";

    /**
     * Constructor for Stake
     * @param x - x-coordinate for Stake
     * @param y - y-coordinate for Stake
     */
    public Stake(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, buyPrice, type);
    }

    /**
     * Getter for damage
     * @return damage
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Getter for damage dealt to vampires
     * @return vampireDamage
     */
    public int getVampireDamage() {
        return vampireDamage;
    }
}
