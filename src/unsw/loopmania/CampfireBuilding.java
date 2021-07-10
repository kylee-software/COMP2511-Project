package unsw.loopmania;

import javafx.beans.property.SimpleIntegerProperty;

public class CampfireBuilding extends Building {

    private int damageBonus;
    private int battleRadius;
    private Character character;

    public CampfireBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public void scareVampire(Vampire vampire) {
        // TODO = need to implement this correctly and add javadoc
    }

    public int getDamageBonus() {
        return damageBonus;
    }

    public int getBattleRadius() {
        return battleRadius;
    }

    public void setDamageBonus(Character character) {
        // TODO = need to implement this correctly and add javadoc
    }

    public void setBattleRadius(int battleRadius) {
        this.battleRadius = battleRadius;
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
