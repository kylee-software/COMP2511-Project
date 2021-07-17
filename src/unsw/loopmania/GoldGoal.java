package unsw.loopmania;

import unsw.loopmania.model.LoopManiaWorld;

public class GoldGoal extends Goal {

    private int goldGoal;
    private LoopManiaWorld world;

    public GoldGoal(int goldGoal, LoopManiaWorld world) {
        this.goldGoal = goldGoal;
        this.world = world;
    }

    /**
     * check if the gold goal is satisfied or not
     * @return true if the player reached the gold goal else false
     */
    @Override
    public boolean isGoalComplete() {
        return world.getGold() == goldGoal;
    }
}
