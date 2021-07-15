package unsw.loopmania;

public class OrGoal extends Goal {

    private boolean conditionA;
    private boolean conditionB;

    public OrGoal(boolean conditionA, boolean conditionB) {
        this.conditionA = conditionA;
        this.conditionB = conditionB;
    }

    /**
     * to check if any of the two goals is satisfied or not
     * @return true if the player completed one of the two goals else false
     */
    @Override
    public boolean evaluateGoal() {
        return conditionA || conditionB;
    }
}
