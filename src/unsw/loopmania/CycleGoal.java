package unsw.loopmania;

import unsw.loopmania.model.LoopManiaWorld;

public class CycleGoal extends Goal {

    private int cycleGoal;
    private LoopManiaWorld world;

    public CycleGoal(int cycleGoal, LoopManiaWorld world) {
        this.cycleGoal = cycleGoal;
    }

    /**
     * check if the cycle goal is satisfied or not
     * @return true if the player reached the cycle goal else false
     */
    @Override
    public boolean isGoalComplete() {
        return world.getCycle() == cycleGoal;
    }
}
