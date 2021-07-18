package unsw.loopmania.model.AttackStrategy;

import unsw.loopmania.model.MovingEntity;

public interface AttackStrategy {
    public Boolean execute(MovingEntity attacker, MovingEntity target, int scalarDef, int fixedDef, Boolean campfire);
}
