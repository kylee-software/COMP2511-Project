package unsw.loopmania.Items.RareItems;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.Items.Item;

/**
 * Abstract class for equipped or unequipped rare items in the backend world
 */
public abstract class RareItem extends Item {
    
    private static int sellPrice = 150;

    /**
     * Constructor for RareItem
     * @param x - x-coordinate of item
     * @param y - y-coordinate of item
     */
    public RareItem(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y, sellPrice);
    }
}

