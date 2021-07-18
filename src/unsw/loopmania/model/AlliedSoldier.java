package unsw.loopmania.model;

import javafx.beans.property.SimpleIntegerProperty;

public class AlliedSoldier extends StaticEntity {

    private int health = 100;
    private int max;

    public AlliedSoldier(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public int getHealth() {
        return health;
    }

    public int getMax() {
        return max;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        // TODO = need to implement this correctly and add javadoc
        return false;
    }
}
