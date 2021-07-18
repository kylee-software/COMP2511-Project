package unsw.loopmania.model.AttackStrategy;

import unsw.loopmania.model.Character;
import unsw.loopmania.model.MovingEntity;

/**
 * Implements slug attack on a target
 */
public class SlugAttack implements AttackStrategy {
    /**
     * Execute slug attack on a target.
     * Applies defences if target is a Character.
     * @param attacker - character
     * @param target - enemy target
     * @param scalarDef - target scalar defences
     * @param fixedDef - target fixed defences
     * @param campfire - is campfire in range?
     * @return apply special effects
     */
    @Override
    public Boolean execute(MovingEntity attacker, MovingEntity target, int scalarDef, int fixedDef, Boolean campfire) {
        double damage = attacker.getDamage();
        if (target.getClass().equals(Character.class)) {
            damage *= scalarDef / 100;
            damage -= fixedDef;
        }
        target.setHealth((int)(target.getHealth() - damage));
        return false;
    }
}
