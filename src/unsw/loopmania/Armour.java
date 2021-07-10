package unsw.loopmania;

public class Armour extends BasicItems implements DefenceBehaviour {

    private String name;
    private int scalarDamageReduction;

    public Armour(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice, buyPrice);
    }

    public int getDamageReduction() {
        return scalarDamageReduction;
    }
}
