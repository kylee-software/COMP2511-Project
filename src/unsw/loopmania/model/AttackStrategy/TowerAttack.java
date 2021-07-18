package unsw.loopmania.model.AttackStrategy;

import unsw.loopmania.model.MovingEntity;

/**
* Implements tower attack for a tower on an target
*/
public class TowerAttack extends AttackObserver implements AttackStrategy {
    private int towerDamage = 3;

    /**
     * Execute tower attack on an enemy target
     * @param attacker - character
     * @param target - enemy target
     * @param scalarDef - target scalar defences
     * @param fixedDef - target fixed defences
     * @param campfire - is campfire in range?
     * @return apply special effects
     */
    @Override
    public Boolean execute(MovingEntity attacker, MovingEntity target, int scalarDef, int fixedDef, Boolean campfire) {
        target.setHealth(target.getHealth() - towerDamage);
        return false;
    }
}
