package unsw.loopmania.model.Goal;

public class GoldGoal extends Goal {

    private int goldGoal;
    private int worldGold;

    public GoldGoal(int goldGoal) {
        this.goldGoal = goldGoal;
    }

    public void setWorldGold(int worldGold) {
        this.worldGold = worldGold;
    }

    /**
     * check if the gold goal is satisfied or not
     * @return true if the player reached the gold goal else false
     */
    @Override
    public boolean isGoalComplete() {
        return worldGold == goldGoal;
    }
}
