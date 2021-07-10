package unsw.loopmania;

import java.util.ArrayList;
import java.util.List;

public class HerosCastleBuilding extends Building {

    private String gameMode;
    private List<Item> boughtItems;

    public HerosCastleBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    // is this necessary?
    public String getGameMode() {
        return gameMode;
    }

    public List<Item> getBoughtItems() {
        // TODO = need to implement this correctly and add javadoc
        return new ArrayList<>();
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void addBoughtItem(Item item) {
        // TODO = need to implement this correctly and add javadoc
    }

    public void resetBoughtItems() {
        // TODO = need to implement this correctly and add javadoc
    }

    public void buyItem(Item item) {
        // TODO = need to implement this correctly and add javadoc
    }

    public void sellItem(Item item) {
        // TODO = need to implement this correctly and add javadoc
    }

    public boolean isValidInMode() {
        // TODO = need to implement this correctly and add javadoc
        return false;
    }
}
