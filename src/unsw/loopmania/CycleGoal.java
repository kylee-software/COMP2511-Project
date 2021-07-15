package unsw.loopmania;

public class CycleGoal extends Goal {

    private final int cycleGoal = 30;
    private int cycle;

    public CycleGoal(int cycle) {
        this.cycle = cycle;
    }

    /**
     * check if the cycle goal is satisfied or not
     * @return true if the player reached the cycle goal else false
     */
    @Override
    public boolean evaluateGoal() {
        return cycle == cycleGoal;
    }
}
