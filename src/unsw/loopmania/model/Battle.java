package unsw.loopmania.model;

import java.util.List;

import unsw.loopmania.model.Buildings.TowerBuilding;
import unsw.loopmania.model.Cards.Card;
import unsw.loopmania.model.Enemies.BasicEnemy;
import unsw.loopmania.model.Items.Item;

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
     * Getter for list of killed enemies
     */
    public List<BasicEnemy> getKilledEnemies() {
        return this.killedEnemies;
    }

    public void sortListByCurrentHp() {
        // TODO:
    }

    public void fight() {
        // TODO:
    }

    /**
     * Checks if all enemies are dead
     */
    private boolean areEnemiesDead() {
        if (liveEnemies.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks if battle was lost
     * @return loss status
     */
    public Boolean isLost() {
        if (character.getHealth() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Deals damage to given receiver based on dealer stats
     * @param dealer - damage dealer moving entity
     * @param receiver - damage receiver moving entity
     */
    private void dealDamage(MovingEntity dealer, MovingEntity receiver) {
        // TODO: account for defensive stats
        receiver.setHealth(receiver.getHealth() - dealer.getDamage());
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
