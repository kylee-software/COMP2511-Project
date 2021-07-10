package unsw.loopmania;

public class Helmet extends BasicItems implements DefenceBehaviour {

    private String name;
    private int scalarDamageReduction;
    private int damageDealtReduction;

    public Helmet(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice, buyPrice);
    }

    public int getDamageReduction() {
        // TODO = need to implement this correctly and add javadoc
        return 0;
    }
}
