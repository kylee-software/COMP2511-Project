package unsw.loopmania;

public class HealthPotion extends BasicItems {

    private String name;

    public HealthPotion(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice, buyPrice);
    }

    public void usePotion(Character character) {
        // TODO = need to implement this correctly and add javadoc
    }

}
