package unsw.loopmania.model.Goal;

import unsw.loopmania.model.LoopManiaWorld;

public class CycleGoal extends Goal {

    private int cycleGoal;
    private int worldGoal;

    public CycleGoal(int cycleGoal) {
        this.cycleGoal = cycleGoal;
    }


    public void setWorldGoal(int worldGoal) {
        this.worldGoal = worldGoal;
    }

    /**
     * check if the cycle goal is satisfied or not
     * @return true if the player reached the cycle goal else false
     */
    @Override
    public boolean isGoalComplete() {
        return worldGoal == cycleGoal;
    }
}
