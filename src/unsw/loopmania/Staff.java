package unsw.loopmania;
import javafx.beans.property.SimpleIntegerProperty;

public class Staff extends BasicItems {

    private String name;
    private int damage;
    private int tranceChance;

    public Staff(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice, buyPrice);
    }

    public int getDamage() {
        return damage;
    }

    public int getTranceChance() {
        return tranceChance;
    }
}
