package unsw.loopmania.Items.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Equipped or unequipped Health Potion in the backend world
 */
public class HealthPotion extends BasicItem {

    private static int buyPrice = 20;
    private static String type = "HealthPotion";

    /**
     * Constructor for Health Potion
     * @param x - x-coordinate for Health Potion
     * @param y - y-coordinate for Health Potion
     */
    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, buyPrice, type);
    }

    /**
     * Use health potion on character.
     * Restores character to full health.
     * @param c - Character to apply health potion to
     */
    public void usePotion(Character c) {
        c.setHealth(100);
    }
}
