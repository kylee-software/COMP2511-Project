package unsw.loopmania.model.Buildings;

import javafx.beans.property.SimpleIntegerProperty;
import unsw.loopmania.model.AttackStrategy.AttackStrategy;
import unsw.loopmania.model.AttackStrategy.TowerAttack;


public class TowerBuilding extends Building {

    private int damage = 3;
    private int battleRadius = 3;
    AttackStrategy attackStrategy = new TowerAttack();

    public TowerBuilding(SimpleIntegerProperty x, SimpleIntegerProperty y) {
        super(x, y);
    }

    public int getDamage() {
        return this.damage;
    }

    public int getBattleRadius() {
        return this.battleRadius;
    }

    public AttackStrategy getAttackStrategy() {
        return this.attackStrategy;
    }

    /**
     * Attacks an enemy in its battle radius during battle
     */
    public void attack() {
        // TODO: coordinate with attack strategy implementation
        getAttackStrategy().execute();
    }

}
