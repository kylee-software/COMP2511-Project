package unsw.loopmania;

public class AndGoal extends Goal {

    private Goal goalA;
    private Goal goalB;

    public AndGoal(Goal goalA, Goal goalB) {
        this.goalA = goalA;
        this.goalB = goalB;
    }

    /**
     * to check if two goals are satisfied or not
     * @return true if the player completed both goals else false
     */
    @Override
    public boolean evaluateGoal() {
        boolean resultA = goalA.evaluateGoal();
        boolean resultB = goalB.evaluateGoal();

        return resultA && resultB;
    }
}
