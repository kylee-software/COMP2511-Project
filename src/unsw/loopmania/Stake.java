package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class Stake extends BasicItems{

    private String name;
    private int damage;
    private int vampireDamage;

    public Stake (SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice, buyPrice);
    }

    public int getDamage() {
        return damage;
    }

    public int getVampireDamage() {
        return vampireDamage;
    }
}
