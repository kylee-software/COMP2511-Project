package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;


public class TowerBuilding extends Building {

    private int damage;
    private int battleRadius;

    public TowerBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public int getDamage() {
        return damage;
    }

    public int getBattleRadius() {
        return battleRadius;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setBattleRadius(int battleRadius) {
        this.battleRadius = battleRadius;
    }

    public void attackStrategy(AttackStrategy attackStrategy) {
        // TODO = need to implement this correctly and add javadoc
    }

}
