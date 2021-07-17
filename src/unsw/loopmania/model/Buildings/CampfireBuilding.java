package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.Enemies.Vampire;
import unsw.loopmania.model.Character;

public class CampfireBuilding extends Building {

    private int battleRadius = 2;

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public void scareVampire(Vampire vampire) {
        // TODO = need to implement this correctly and add javadoc
    }

    public int getBattleRadius() {
        return battleRadius;
    }

    // BUFFER INTERFACE
    public void performDamage(Character character) {
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
