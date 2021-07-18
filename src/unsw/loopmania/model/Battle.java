package unsw.loopmania.model;

import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import unsw.loopmania.model.AttackStrategy.*;
import unsw.loopmania.model.Buildings.*;
import unsw.loopmania.model.Cards.Card;
import unsw.loopmania.model.Enemies.*;
import unsw.loopmania.model.Items.Item;
import unsw.loopmania.model.Items.BasicItems.*;

public class Battle {

    private Character character;
    private List<Building> towers;
    private List<AlliedSoldier> allies;
    private List<Building> campfires;
    private List<BasicEnemy> liveEnemies;
    private List<BasicEnemy> killedEnemies;
    private Item weapon = null;
    private Item armour = null;
    private Item shield = null;
    private Item helmet = null;
    private int characterDamage = character.getDamage();

    /**
     * Constructor for a battle
     * @param character
     * @param towers - list of towers to join battle
     * @param allies - list of allied soldiers to join battle
     * @param enemies - list of enemies to join battle
     * @param campfires - list of campfires in battle range
     */
    public Battle (
        Character character,
        List<Building> towers,
        List<AlliedSoldier> allies,
        List<BasicEnemy> enemies,
        List <Building> campfires
    ) {
        this.character = character;
        this.towers = towers;
        this.allies = allies;
        this.liveEnemies = enemies;
        this.campfires = campfires;
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
     * Setter for equipped weapon
     * @param weapon
     */
    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    /**
     * Setter for equipped armour
     * @param armour
     */
    public void setArmour(Item armour) {
        this.armour = armour;
    }

    /**
     * Setter for equipped Shield
     * @param shield
     */
    public void setShield(Item shield) {
        this.shield = shield;
    }

    /**
     * Setter for equipped helmet
     * @param helmet
     */
    public void setHelmet(Item helmet) {
        this.helmet = helmet;
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

    /**
     * Getter for list of killed allies
     * @return list of dead allies
     */
    public List<AlliedSoldier> getKilledAllies() {
        List<AlliedSoldier> deadAllies = new ArrayList<AlliedSoldier>();
        for (AlliedSoldier ally : allies) {
            if (ally.isDead()) {
                deadAllies.add(ally);
            }
        }
        return deadAllies;
    }

    public void sortEnemiesByCurrentHp() {
        liveEnemies.sort(Comparator.comparing(BasicEnemy::getHealth));
    }

    public void sortAlliesByCurrentHp() {
        allies.sort(Comparator.comparing(AlliedSoldier::getHealth));
    }

    public void fight() {
        // Character -> Tower1 → Allied Soldier 1 -> Enemy 1 → character → Tower2 → Allied Soldier 2 → Enemy2
        // Characters and enemies will attack the entity with the lowest current health every turn
        // Enemies will attack allied soldiers first
        sortEnemiesByCurrentHp();
        sortAlliesByCurrentHp();
        int scalarDef = getScalarDef();
        int flatDef = getFlatDef();
        int towerTurn = 0;
        int allyTurn = 0;
        int enemyTurn = 0;
        while (!areEnemiesDead() && !character.isDead()) {
            // character attack enemy 0
            // tower 0 attack enemy 0
            // allied soldier 0 attack enemy 0
            // enemy 0 attack allied soldier 0
            Boolean trance = attackLiveEnemy(character);
            attackLiveEnemy(towers.get(towerTurn % towers.size()));
            towerTurn += 1;
            towerTurn %= towers.size();
            attackLiveEnemy(allies.get(allyTurn));
            allyTurn += 1;
            allyTurn %= allies.size();
            // check next ally is alive
            Boolean infect = enemyAttack(liveEnemies.get(enemyTurn), scalarDef, flatDef);
            enemyTurn += 1;
            enemyTurn %= liveEnemies.size();
            // check next enemy is alive
        }
    }

    /**
     * Attack first live enemy
     * @param attacker
     * @return staff trance?
     */
    private Boolean attackLiveEnemy(Entity attacker) {
        AttackStrategy attack = attacker.getAttackStrategy();
        if (attacker.getClass().equals(Character.class)) {
            attack = getItemAttackStrategy();
        }
        for (int i = 0; i < liveEnemies.size(); i++) {
            BasicEnemy enemy = liveEnemies.get(i);
            if (!enemy.isDead()) {
                return attack.execute(character, enemy, 0, 0, campfires.size() > 0);
            }
        }
        return false;
    }

    /**
     * For a given enemy attacks lowest ally else character
     * @param attacker - enemy
     * @param scalarDef - character scalar damage reduction
     * @param flatDef - character flat damage reduction
     * @return zombie crit?
     */
    private Boolean enemyAttack(Entity attacker, int scalarDef, int flatDef) {
        AttackStrategy attack = attacker.getAttackStrategy();
        // Prioritise allies
        for (int i = 0; i < allies.size(); i++) {
            AlliedSoldier ally = allies.get(i);
            if (!ally.isDead()) {
                return attack.execute(attacker, ally, 0, 0, campfires.size() > 0);
            }
        }
        // Otherwise attack character
        return attack.execute(attacker, character, scalarDef, flatDef, campfires.size() > 0);
    }

    /**
     * Gets attack strategy for character
     * @return attack strategy instance
     */
    private AttackStrategy getItemAttackStrategy() {
        if (weapon == null) {
            return new BasicAttack();
        } else if (weapon.getClass().equals(Sword.class)) {
            return new SwordAttack();
        } else if (weapon.getClass().equals(Stake.class)) {
            return new StakeAttack();
        } else if (weapon.getClass().equals(Staff.class)) {
            return new StaffAttack();
        }
        return null;
    }

    /**
     * Gets scalar damage reduction for character
     * @return percentage of damage reduction
     */
    private int getScalarDef() {
        int scalarDef = 0;
        if (armour != null) {
            scalarDef += armour.getScalarDamageReduction();
        }
        if (helmet != null) {
            scalarDef += helmet.getScalarDamageReduction();
        }
        return scalarDef;
    }

    /**
     * Gets flat damage reduction for character
     * @return damage reduction
     */
    private int getFlatDef() {
        int flatDef = 0;
        if (shield != null) {
            flatDef += shield.getFlatDamageReduction();
        }
        return flatDef;
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
     * Gets total EXP reward for the battle
     * @return total experience gained
     */
    public int getBattleExp() {
        int xp = 0;
        for (BasicEnemy enemy : killedEnemies) {
            xp += enemy.getExpReward();
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
    public List<String> getBattleItems() {
        List<String> items = new ArrayList<String>();
        // for (BasicEnemy enemy : killedEnemies) {
        //     items.add(generateRandomItem());
        // }
        return items;
    }

}
