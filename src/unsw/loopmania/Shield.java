package unsw.loopmania;
import javafx.beans.property.SimpleIntegerProperty;

public class Shield extends BasicItems implements DefenceBehaviour {

    private String name;
    private int flatDamageReduction;
    private int vampireCritReduction;

    public Shield(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice, buyPrice);
    }

    public int getDamageReduction() {
        // TODO = need to implement this correctly and add javadoc
        return 0;
    }
}
