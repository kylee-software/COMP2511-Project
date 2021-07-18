package unsw.loopmania.Goal;

public class OrGoal extends Goal {

    private Goal goalA;
    private Goal goalB;

    public OrGoal(Goal goalA, Goal goalB) {
        this.goalA = goalA;
        this.goalB = goalB;
    }

    /**
     * to check if any of the two goals is satisfied or not
     * @return true if the player completed one of the two goals else false
     */
    @Override
    public boolean isGoalComplete() {
        return goalA.isGoalComplete() || goalB.isGoalComplete();
    }
}
