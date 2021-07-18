package unsw.loopmania.model.AttackStrategy;

import java.util.Random;

import unsw.loopmania.model.AlliedSoldier;
import unsw.loopmania.model.Entity;
import unsw.loopmania.model.MovingEntity;

/**
 * Implements a zombie attack on a target
 */
public class ZombieAttack implements AttackStrategy {

    /**
     * Execute zombie attack on a target.
     * Applies defences if target is a Character.
     * @param attacker - character
     * @param target - enemy target
     * @param scalarDef - target scalar defences
     * @param fixedDef - target fixed defences
     * @param campfire - is campfire in range?
     * @return apply special effects
     */
    @Override
    public Boolean execute(Entity attacker, MovingEntity target, int scalarDef, int fixedDef, Boolean campfire) {
        double damage = attacker.getDamage();
        Random random = new Random();
        Boolean crit = random.nextInt(99) < attacker.getCritChance();
        if (target.getClass().equals(Character.class)) {
            damage *= scalarDef / 100;
            damage -= fixedDef;
        }
        target.setHealth((int)(target.getHealth() - damage));
        if (crit && target.getClass().equals(AlliedSoldier.class)) {
            return true;
        } else {
            return false;
        }
    }
}
