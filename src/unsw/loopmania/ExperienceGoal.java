package unsw.loopmania;

public class ExperienceGoal extends Goal {

    private final int expPointGoal = 15000;
    private int expPoint;

    public ExperienceGoal(int expPoint) {
        this.expPoint = expPoint;
    }


    /**
     * check if the experience points goal is satisfied or not
     * @return true if the player reached the experience point goal else false
     */
    @Override
    public boolean evaluateGoal() {
        return expPoint == expPointGoal;
    }
}
