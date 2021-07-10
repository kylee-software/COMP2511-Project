package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * represents an equipped or unequipped sword in the backend world
 */
public class Sword extends BasicItems {

    // original starter code
//    // TODO = add more weapon/item types
//    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y) {
//        super(x, y);
//    }

    private String name;
    private int damage;

    public Sword(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice, buyPrice);
    }

    public int getDamage() {
        return damage;
    }


}
