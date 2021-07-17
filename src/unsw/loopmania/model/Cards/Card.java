package unsw.loopmania.model.Cards;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.StaticEntity;
import unsw.loopmania.model.Cards.PositionStrategy.PositionStrategy;
import unsw.loopmania.model.Items.Item;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.javatuples.Pair;

/**
 * the items that can be obtained as reward 
 * If more item types are added, add an enum value here.
 */
enum ITEM {
    Sword, Stake, Staff, Armour, Shield, Helmet, HealthPotion;

    /**
     * Pick a random value of the ITEM enum.
     * @return a random ITEM.
     */
    public static ITEM getRandomItem() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}

/**
 * a Card in the world which doesn't move
 */
public abstract class Card extends StaticEntity {

    private int goldReward = 20;
    private int expReward = 100;
    private List<Item> itemReward = new ArrayList<>();

    // DONE = implement other varieties of card than VampireCastleCard
    public Card(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public abstract PositionStrategy getPositionStrategy();

    public int getGoldReward() {
        return this.goldReward;
    }

    public int getExpReward() {
        return this.expReward;
    }

    public List<Item> getItemReward() {
        return this.itemReward;
    }
    
    /**
     * Check if the card can be placed at the given coordinates to be converted
     * into its corresponding building
     * @param buildingNodeX x coordinate for potential building placement
     * @param buildingNodeY y coordinate for potential building placement
     * @param orderedPath list of path tiles
     * @return true if the card can be placed, otherwise false
     */
    public boolean validPosition(int buildingNodeX, int buildingNodeY, List<Pair<Integer, Integer>> orderedPath) {
        return getPositionStrategy().validPosition(buildingNodeX, buildingNodeY, orderedPath);
    }

    /**
     * Add a random number of random items to item rewards list
     */
    public void setItemReward() {
        
        int itemCount = new Random().nextInt(3) + 1;

        Class<?> itemClass;
        Class<?>[] parameterType;
        Item item;
        for (int i = 0; i < itemCount; i++) {        
            try {
                itemClass = Class.forName("unsw.loopmania.model.Items.BasicItems." + ITEM.getRandomItem().name());
                parameterType = new Class[] { SimpleIntegerProperty.class, SimpleIntegerProperty.class };
                item = (Item) itemClass.getDeclaredConstructor(parameterType).newInstance(new SimpleIntegerProperty(),
                        new SimpleIntegerProperty());
                getItemReward().add(item);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                // DONE Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}