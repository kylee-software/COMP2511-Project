package unsw.loopmania;

import java.util.List;

import unsw.loopmania.Items.Item;

/**
 * Class for a single battle in the backend world
 */
public class Battle {

    private Character character;
    private List<TowerBuilding> towers;
    private List<AlliedSoldier> allies;
    private List<BasicEnemy> liveEnemies;
    private List<BasicEnemy> killedEnemies;

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
        this.liveEnemies = enemies;
    }

    /**
     * Given an enemy adds to the list of enemies for the battle
     * @param enemy - enemy to add
     */
    public void addEnemyToBattle(BasicEnemy enemy) {
        if (enemy.getHealth() > 0) {
            this.liveEnemies.add(enemy);
        }
    }

    /**
     * Removes given enemy from list of alive enemies.
     * Adds enemy to list of killed enemies
     * @param enemy - enemy to kill
     */
    public void killEnemy(BasicEnemy enemy) {
        this.liveEnemies.remove(enemy);
        this.killedEnemies.add(enemy);
    }

    /**
     * Checks if all enemies are dead
     */
    public boolean areEnemiesDead() {
        if (liveEnemies.size() == 0) {
            return true;
        }
        return false;
    }

    public void sortListByCurrentHp() {
        // TODO = need to implement this correctly and add javadoc
    }

    public void fight() {
        // TODO = need to implement this correctly and add javadoc
    }

    /**
     * Gets total EXP reward for the battle
     * @return total experience gained
     */
    public int getBattleExp() {
        int xp = 0;
        for (BasicEnemy enemy : killedEnemies) {
            xp += enemy.getEXPReward();
        }
        return xp;
    }

    /**
     * Gets total gold reward for the battle
     * @return total gold gained
     */
    public int getBattleGold() {
        int gold = 0;
        for (BasicEnemy enemy : killedEnemies) {
            gold += enemy.getGoldReward();
        }
        return gold;
    }

    /**
     * Gets card rewards for battle
     * @return list of cards gained
     */
    public List<Card> getBattleCards() {
        TODO:
        return null;
    }

    /**
     * Gets item rewards for battle
     * @return list of items gained
     */
    public List<Item> getBattleItems() {
        TODO:
        return null;
    }
}
