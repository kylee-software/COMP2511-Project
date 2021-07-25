package unsw.loopmania.model.Goal;

import unsw.loopmania.model.LoopManiaWorld;

public class BossGoal extends Goal {

    /**
     * check whether the character killed all the bosses or not.
     * @param world the current Loop Mania World
     * @return true if the character killed all the bosses else false
     */
    @Override
    public boolean isGoalComplete(LoopManiaWorld world) {
        return world.getBosses().isEmpty();
    }
}
