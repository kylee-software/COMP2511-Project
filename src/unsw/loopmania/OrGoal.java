package unsw.loopmania;

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
    public boolean evaluateGoal() {
        boolean resultA = goalA.evaluateGoal();
        boolean resultB = goalB.evaluateGoal();

        return resultA || resultB;
    }
}
