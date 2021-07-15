package unsw.loopmania.Items;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.StaticEntity;

public abstract class Item extends StaticEntity {
    
    private int sellPrice;
    private int discardGold = this.getSellPrice()/2;
    private int discardExp = 100;
    private String type;

    /**
     * Constructor for Item
     * @param x - x-coordinate of item
     * @param y - y-coordinate of item
     * @param sellPrice - sellPrice of item
     */
    public Item(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, String type) {
        super(x, y, sellPrice);
        this.sellPrice = sellPrice;
        this.type = type;
    }

    /**
     * Getter for sellPrice
     * @return sellPrice
     */
    public int getSellPrice() {
        return this.sellPrice;
    }

    /**
     * Getter for type corresponding to inventory slot (Weapon, Shield, Armour, etc.)
     */
    public String getType() {
        return this.type;
    }

    /**
     * Increases gold and XP for character when an item is discarded
     */
    public void addDiscardReward() {
        // TODO: use setGold in loopMania?
    }
}
