package unsw.loopmania.model;

import unsw.loopmania.model.AttackStrategy.*;

/**
 * represents the main character in the backend of the game world
 */
public class Character extends MovingEntity {

    private static AttackStrategy strategy = new BasicAttack();
    private static int health = 100;
    private static int baseDamage = 6;
    private static int speed = 2; // Ticks per tile
    private boolean stuckOnGlacier;
    private int frozenTicks = 0;
    private boolean unfreeze = false;
    private boolean inCloakingTowerRange;
    private int cloakTicks = 0;

    public Character(PathPosition position) {
        super(position, health, speed);
    }

    public void move(){
        if (frozenTicks > 0) {
            frozenTicks--;
        } else {
            unfreeze = false;
            moveDownPath();
        }
    }
    /**
     * Getter for damage of character (base + weapons)
     * @return damage
     */
    public int getDamage() {
        return baseDamage;
    }

    /**
     * Getter for attack strategy
     */
    public AttackStrategy getAttackStrategy() {
        return strategy;
    }

    public boolean getStuckOnGlacier() {
        return stuckOnGlacier;
    }

    public int getFrozenTicks() {
        return frozenTicks;
    }

    public boolean getUnfreeze() {
        return unfreeze;
    }

    @Override
    public void setStuckOnGlacier(boolean stuckOnGlacier) {
        if (frozenTicks > 0) {
            this.stuckOnGlacier = stuckOnGlacier;
        } else if (stuckOnGlacier && unfreeze == false) {
            this.stuckOnGlacier = stuckOnGlacier;
            frozenTicks = 3;
        }
    }

    public void setUnfreeze(boolean unfreeze) {
        this.unfreeze = unfreeze;
    }

    public boolean getInCloakingTowerRange() {
        return inCloakingTowerRange;
    }

    public void setInCloakingTowerRange(boolean inCloakingTowerRange) {
        if (cloakTicks > 0) {
            this.inCloakingTowerRange = inCloakingTowerRange;
        } else if (inCloakingTowerRange) {
            this.inCloakingTowerRange = inCloakingTowerRange;
            cloakTicks = 3;
        }
    }
    
}
