package unsw.loopmania;

import java.util.List;

/**
 * Class for a single battle in the backend world
 */
public class Battle {

    private Character character;
    private List<TowerBuilding> towers;
    private List<AlliedSoldier> allies;
    private List<BasicEnemy> enemies;

    /**
     * Constructor for a battle
     * @param character
     * @param towers - list of towers to join battle
     * @param allies - list of allied soldiers to join battle
     * @param enemies - list of enemies to join battle
     */
    public Battle(Character character, List<TowerBuilding> towers, List<AlliedSoldier> allies, List<BasicEnemy> enemies) {
        this.character = character;
        this.towers = towers;
        this.allies = allies;
        this.enemies = enemies;
    }

    /**
     * Given an enemy adds to the list of enemies for the battle
     * @param enemy - enemy to add
     */
    public void addEnemyToBattle(BasicEnemy enemy) {
        if (enemy.getHealth() > 0) {
            this.enemies.add(enemy);
        }
    }

    /**
     * Removes given enemy from list of enemies
     * @param enemy - enemy to kill
     */
    public void killEnemy(BasicEnemy enemy) {
        this.enemies.remove(enemy);
    }

    /**
     * Checks if all enemies are dead
     */
    public boolean areEnemiesDead() {
        for (BasicEnemy enemy : enemies) {
            if (enemy.getHealth > 0) {
                return true;
            }
        }
        return true;
    }

    public void sortListByCurrentHp() {
        // TODO = need to implement this correctly and add javadoc
    }

    public void fight() {
        // TODO = need to implement this correctly and add javadoc
    }
}
