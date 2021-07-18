package unsw.loopmania;

import unsw.loopmania.model.LoopManiaWorld;

public class ExperienceGoal extends Goal {

    private int expPointGoal;
    private LoopManiaWorld world;

    public ExperienceGoal(int expPointGoal, LoopManiaWorld world) {
        this.expPointGoal = expPointGoal;
        this.world = world;
    }


    /**
     * check if the experience points goal is satisfied or not
     * @return true if the player reached the experience point goal else false
     */
    @Override
    public boolean isGoalComplete() {
        return world.getExperience() == expPointGoal;
    }
}
