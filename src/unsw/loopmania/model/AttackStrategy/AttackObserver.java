package unsw.loopmania.model.AttackStrategy;

public class AttackObserver {
    private static int getDamageMultiplier = 2;

    /**
     * Getter for campfire damage multiplier
     * @return damage multiplier
     */
    public int campfireBuff() {
        return getDamageMultiplier;
    }
}
