package unsw.loopmania.model.Goal;

public class ExperienceGoal extends Goal {

    private int expPointGoal;
    private int worldGoal;

    public ExperienceGoal(int expPointGoal) {
        this.expPointGoal = expPointGoal;
    }

    public void setWorldGoal(int worldGoal) {
        this.worldGoal = worldGoal;
    }

    /**
     * check if the experience points goal is satisfied or not
     * @return true if the player reached the experience point goal else false
     */
    @Override
    public boolean isGoalComplete() {
        return worldGoal == expPointGoal;
    }
}
