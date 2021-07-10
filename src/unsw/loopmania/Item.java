package unsw.loopmania;

public abstract class Item extends StaticEntity {

    private int sellPrice;

    public Item(SimpleIntegerProperty x, SimpleIntegerProperty y, int sellPrice) {
        super(x, y);
        this.sellPrice = sellPrice;
    }

    public int getSellPrice(){
        return sellPrice;
    };
}
