package unsw.loopmania.model.Buildings;

import java.util.ArrayList;
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

    public int sellItem(Item item, List<Item> unequippedInventory) {
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
    public boolean isValidPurchase(String gameMode, BasicItem item, int cycles) {
        if (gameMode.equals("Survival")) {
            if (item instanceof HealthPotion) {
                // check when is the last time the character purchased a health potion
                if (cycles % 5 == 0 && cycles >= 0 && lastPurchasedHP < cycles) {
                    lastPurchasedHP = cycles;
                    return true;
                } else {
                    return false;
                }
            }
        } else if (gameMode.equals("Berserker")) {
            if (item instanceof Armour || item instanceof Helmet || item instanceof Shield) {
                // check when is the last time the character purchased a protective gear
                if (cycles > 0 && lastPurchasedPG < cycles) {
                    lastPurchasedPG = cycles;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
