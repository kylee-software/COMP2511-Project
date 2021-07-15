package unsw.loopmania.model;

import java.util.List;

import unsw.loopmania.model.Buildings.TowerBuilding;

public class Battle {

    private Character character;
    private TowerBuilding tower;
    private List<AlliedSoldier> allies;
    private List<BasicEnemy> enemies;

    public Battle(Character character, TowerBuilding tower, List<AlliedSoldier> allies, List<BasicEnemy> enemies) {
        this.character = character;
        this.tower = tower;
        this.allies = allies;
        this.enemies = enemies;
    }

    public void addEnemiesToTower() {
        // TODO = need to implement this correctly and add javadoc
    }

    public boolean areEnemiesDead() {
        // TODO = need to implement this correctly and add javadoc
        return false;
    }

    public void sortListByCurrentHp() {
        // TODO = need to implement this correctly and add javadoc
    }

    public void fight() {
        // TODO = need to implement this correctly and add javadoc
    }
}
