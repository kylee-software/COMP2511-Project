package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

import java.util.List;

/**
 * a Card in the world
 * which doesn't move
 */
public abstract class Card extends StaticEntity {

    private int goldReward;
    private int expReward;
    private List<Item> itemReward;

    // TODO = implement other varieties of card than VampireCastleCard
    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public boolean validPosition(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        // TODO = need to implement this correctly and add javadoc
        return false;
    }

    // TODO = need to implement this correctly and add javadoc
    public List<Item> getRewards(int count, int integ, List<Item> items) {
        return itemReward;
    }
}
