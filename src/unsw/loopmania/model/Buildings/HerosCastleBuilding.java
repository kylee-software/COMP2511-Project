package unsw.loopmania.model.Buildings;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;

public class HerosCastleBuilding extends Building {

    private String gameMode;
    private List<Item> boughtItems;

    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y, String gameMode) {
        super(x, y);
        this.gameMode = gameMode;
    }

    public String getGameMode() {
        return this.gameMode;
    }

    public List<Item> getBoughtItems() {
        return this.boughtItems;
    }

    public void resetBoughtItems() {
        this.boughtItems = new ArrayList<>();
    }

    public int buyItem(BasicItem item, List<Item> unequippedInventory) {
        unequippedInventory.add(item);
        getBoughtItems().add(item);
        return item.getBuyPrice();
    }

    public int sellItem(Item item, List<Item> unequippedInventory) {
        unequippedInventory.remove(item);
        return item.getSellPrice();
    }

    /**
     * Check if mode allows for given item to be bought
     * @param item item player wants to purchase
     * @return true if purchase is valid, otherwise false
     */
    public boolean canBuyInMode(Item item) {
        if (gameMode == "Survival") {
            if (item instanceof HealthPotion) {
                for (Item boughtItem : getBoughtItems()) {
                    if (boughtItem instanceof HealthPotion) 
                        return false;
                }
            }
        } else if (gameMode == "Berserker") {
            if (item instanceof Armour || item instanceof Helmet || item instanceof Shield) {
                for (Item boughtItem : getBoughtItems()) {
                    if (boughtItem instanceof Armour || boughtItem instanceof Helmet || boughtItem instanceof Shield)
                        return false;
                }
            }
        }
        return true;
    }
}
