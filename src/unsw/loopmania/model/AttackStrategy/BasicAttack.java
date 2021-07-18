package unsw.loopmania.model.AttackStrategy;

import unsw.loopmania.model.AlliedSoldier;
import unsw.loopmania.model.MovingEntity;

/**
* Implements basic attack for a character/allied soldier on a target
*/
public class BasicAttack extends AttackObserver implements AttackStrategy {
    /**
     * Execute basic attack on an enemy target
     * @param attacker - character
     * @param target - enemy target
     * @param scalarDef - target scalar defences
     * @param fixedDef - target fixed defences
     * @param campfire - is campfire in range?
     * @return apply special effects
     */
    @Override
    public Boolean execute(MovingEntity attacker, MovingEntity target, int scalarDef, int fixedDef, Boolean campfire) {
        int damage = attacker.getDamage();
        if (campfire && !attacker.getClass().equals(AlliedSoldier.class)) {
            damage *= super.campfireBuff();
        }
        target.setHealth(target.getHealth() - damage);
        return false;
    }

}
