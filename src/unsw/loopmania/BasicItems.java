package unsw.loopmania;

public abstract class BasicItems extends Item {

    private int buyPrice;

    public BasicItems(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice, int buyPrice) {
        super(x, y, sellPrice);
        this.buyPrice = buyPrice;
    }

    public int getBuyPrice() {
        return buyPrice;
    }
}
