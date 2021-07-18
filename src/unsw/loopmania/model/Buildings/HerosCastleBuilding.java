package unsw.loopmania.model.Buildings;

import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;

public class HerosCastleBuilding extends Building {

    private int lastPurchasedHP = 0;
    private int lastPurchasedPG = 0;


    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public int buyItem(BasicItem item, List<Item> unequippedInventory) {
        unequippedInventory.add(item);
        return item.getBuyPrice();
    }

    public int sellItem(BasicItem item, List<Item> unequippedInventory) {
        unequippedInventory.remove(item);
        int price = item.getSellPrice();
        item.destroy();
        return price;
    }

    /**
     * Check if mode allows for given item to be bought
     * @param item item player wants to purchase
     * @return true if purchase is valid, otherwise false
     */
    public boolean isValidPurchase(String gameMode, Item item, int cycles) {
        if (gameMode.equals("Survival")) {
            if (item instanceof HealthPotion) {
                // check when is the last time the character purchased a health potion
                if (lastPurchasedHP == cycles) return false;
                else {
                    lastPurchasedHP = cycles;
                    return true;
                }
            }
        } else if (gameMode.equals("Berserker")) {
            if (item instanceof Armour || item instanceof Helmet || item instanceof Shield) {
                // check when is the last time the character purchased a protective gear
                if (lastPurchasedPG == cycles) return false;
                else {
                    lastPurchasedPG = cycles;
                    return true;
                }
            }
        }
        return true;
    }

}
