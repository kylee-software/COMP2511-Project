package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.Enemies.BasicEnemy;
import unsw.loopmania.model.Character;

public class CampfireBuilding extends Building {

    private static int battleRadius = 2;
    private static int damageMultiplier = 2;

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    @Override
    public int getBattleRadius() {
        return battleRadius;
    }

    @Override
    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    // BUFFER INTERFACE
    public void performDamage(Character character, BasicEnemy enemy) {
        // TODO = need to implement this correctly and add javadoc
    }

    // OBSERVER PATTERN FOR ATTACKS
    public void addAttackObserver(AttackStrategy attackStrategy) {
        // TODO = need to implement this correctly and add javadoc
    }

    public void removeAttackObserver(AttackStrategy attackStrategy) {
        // TODO = need to implement this correctly and add javadoc
    }

    public void notifyAttackObservers() {
        // TODO = need to implement this correctly and add javadoc
    }
}
