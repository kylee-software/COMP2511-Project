package unsw.loopmania.model.Goal;

import unsw.loopmania.model.LoopManiaWorld;

public abstract class Goal {

    /**
     * check if a certain goal is satisfied or not
     * @return true if it is satisfied else false
     */
    public abstract boolean isGoalComplete(LoopManiaWorld world);

}