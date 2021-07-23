package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.Enemies.BasicEnemy;
import unsw.loopmania.model.Character;

public class CampfireBuilding extends Building {

    private static int battleRadius = 2;
    private static int damageMultiplier = 2;
    private static int scareRadius = 3;

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public int getBattleRadius() {
        return battleRadius;
    }

    public int getDamageMultiplier() {
        return damageMultiplier;
    }

    public int getScareRadius() {
        return scareRadius;
    }

    // BUFFER INTERFACE
    public void performDamage(Character character, BasicEnemy enemy) {
    }

    // OBSERVER PATTERN FOR ATTACKS
    public void addAttackObserver(AttackStrategy attackStrategy) {
    }

    public void removeAttackObserver(AttackStrategy attackStrategy) {
    }

    public void notifyAttackObservers() {
    }
}
