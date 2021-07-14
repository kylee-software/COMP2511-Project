package unsw.loopmania;

public class GoldGoal extends Goal {

    private final int goldGoal = 2000;
    private int gold;

    public GoldGoal( int gold) {
        this.gold = gold;
    }

    /**
     * check if the gold goal is satisfied or not
     * @return true if the player reached the gold goal else false
     */
    @Override
    public boolean evaluateGoal() {
        return gold == goldGoal;
    }
}
