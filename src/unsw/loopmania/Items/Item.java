package unsw.loopmania.Items;

import javafx.beans.property.SimpleIntegerProperty;

import unsw.loopmania.StaticEntity;

public abstract class Item extends StaticEntity {
    
    private int sellPrice;
    private int discardGold = this.getSellPrice()/2;
    private int discardExp = 100;

    /**
     * Constructor for Item
     * @param x - x-coordinate of item
     * @param y - y-coordinate of item
     * @param sellPrice - sellPrice of item
     */
    public Item(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice) {
        super(x, y, sellPrice);
        this.sellPrice = sellPrice;
    }

    /**
     * Getter for sellPrice
     * @return sellPrice
     */
    public int getSellPrice() {
        return this.sellPrice;
    }

    /**
     * Increases gold and XP for character when an item is discarded
     */
    public void addDiscardReward() {
        // TODO: use setGold in loopMania?
    }
}
