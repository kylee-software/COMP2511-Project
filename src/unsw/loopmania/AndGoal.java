package unsw.loopmania;

public class AndGoal extends Goal {

    private boolean conditionA;
    private boolean conditionB;

    public AndGoal(boolean conditionA, boolean conditionB) {
        this.conditionA = conditionA;
        this.conditionB = conditionB;
    }

    /**
     * to check if two goals are satisfied or not
     * @return true if the player completed both goals else false
     */
    @Override
    public boolean evaluateGoal() {
        return conditionA == conditionB;
    }
}
