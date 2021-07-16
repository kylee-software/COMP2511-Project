package unsw.loopmania.model.Items.BasicItems;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.MovingEntity;

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
     * @param character - Character to apply health potion to
     */
    @Override
    public void usePotion(MovingEntity character) {
        character.setHealth(100);
    }
}
