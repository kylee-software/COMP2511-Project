package unsw.loopmania.model.Buildings;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;

public class HerosCastleBuilding extends Building {

    private int lastPuchasedHP = 0;
    private int lastPurchasedPG = 0;


    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
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
                if (cycles < lastPuchasedHP) {
                    lastPuchasedHP = cycles;
                    return true;
                } else {
                    return false;
                }
            }
        } else if (gameMode.equals("Berserker")) {
            if (item instanceof Armour || item instanceof Helmet || item instanceof Shield) {
                // check when is the last time the character purchased a protective gear
                if (cycles < lastPurchasedPG) {
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
